1.本模块用来测试entity是如何映射成为一张表的
    
    Entity BrandImageTable会映射成为表brand_image_table
    Entity Brand 会映射成为brand 
2.本模块用来测试如何修改表名

    举例
    如果想要手动的映射表名，可以使用@Table 注解或者@Entity(name = "brandImageTable")
    
3.本模块用来测试Id的生成策略

    项目的Id是可以指定数据库的Id的生成策略的，目前生成策略有
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    TABLE       主键的信息写在一张单独的表 
    SEQUENCE    主键的信息写在一个序列中
    IDENTITY    主键自增（只建议使用这个,要么就不使用了）
    AUTO        Jpa自动选用
    
    ---------------------------------------------
    如果数据库已经存在，那么可以不用指定Id的生成策略
    
    如果数据库不存在，并且使用hibernate自动创建表，=》需要指定表的Id的生成策略
    如果数据库不存在，并且使用自己的sql创建表     =》 不需要指定Id的生成策略，
                                              但是可以指定Id的生成策略
                                              但是此时不推荐使用Id的生成策略
    ---------------------------------------------
    下面说明如何jpa启动执行schema.sql和hibernate自动create ddl的事情
    
    这两种方式都可以创建schema,但是两种冲突. 不建议同时使用。所以有下列的情况:
        1.使用hibernate自动创建数据库schema,并且使用data.sql导入数据
            配置如下:
                开启hibernate
                spring.jpa.hibernate.ddl-auto=update
                spring.jpa.generate-ddl=true
                
                开启data.sql
                spring.datasource.initialization-mode=embedded
                
                此时要保证没有schema.sql在resource路径下
                
        2.使用schema.sql创建数据库schema,并且使用data.sql导入数据
            配置如下:
                关闭hibernate
                spring.jpa.hibernate.ddl-auto=none
                spring.jpa.generate-ddl=false
                
                开启schema.sql data.sql的功能
                spring.datasource.initialization-mode=embedded
             
4.本模块用来测试列如何映射成为列名

    列 brandName 会映射成为 brand_name

5.自定义列名

    自定义列名会在以下情况使用,
        原来的列 与 数据库关键字重复 例如 分组group 和数据库的分组关键字重复
        数据库已经存在的情况下，对应表的列名使用了缩写，在java代码中想要让代码更加可读，导致字段和数据库列名不匹配
        
    使用 :
        @Column(name = "order_group")
        private String group;
    
    高级用法:
        @Column有下列属性:
            
            告诉jpa对应的数据的列是什么即可
            
        name = 
        
        在生产环境下都不建议使用，生产环境数据库通过脚本创建，属性都不需要hibernate来设置
        unique = 
        nullable = 
        insertable = 
        updatable = 
        columnDefinition = hibernate初始化的时候，执行columnDefinition的内容，他是sql脚本
        table = 
        length = 字符串可以使用
        precision = 小数才能使用
        scale = 小数才能使用
        
5.使用嵌入类
    
    什么时候会使用的嵌入类呢? => 比如在商城购物，下订单时，会生成一条订单信息
    
    订单包括以下信息：
        订单id
        商品id
        商品数量
        收件人信息。
        
    收件人信息包括以下内容
        收件人姓名
        收件人手机号
        收件人地址
        
    此时订单 这个类包含了 收件人信息的类
    
    那么此时收件人信息是订单类的 嵌入类。
    
    嵌入类的语法需要标注@Embedable
    
    具体demo见OrderDaoTest

本模块不讨论的内容有
1.Entity使用的数据的类型
    由于在实际的生产场景中，会遇到null的问题，因此不使用原始类型的数据，使用包装类型的数据
    因此，可以使用下列数据
    
    数值
    Byte,Short,Integer,Long,Float,Character,Double
    BigInt,BigDecimal
    
    日期类:
    Date,Time,Calendar

2.使用Entity需要具备的条件
    
    Entity必须是非final的类(换句话说可以被继承)
          方法字段必须是非final的 (需要序列化的字段可以修改)
          
    `需要讨论的内容是Entity对象能否有常亮，能否有业务方法`
    经过测试entity可以有常量，但是不可以有final字段，可以有业务方法。
    
    Entity的字段要小于表的字段
    
    Entity的名称不能与数据库保留字相同。例如order,在数据库中是保留字，因此不能取表名为order
    
3.Entity不考虑外键关联的情况，不考虑多个列构成主键的情况


    