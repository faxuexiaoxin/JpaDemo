这是第三个demo，用于展示jpa的增删改查

# 1.select

## 1.1普通查找

- 使用find函数查找

  下面展示count,distinct,page,sort,limit的代码

## 1.2条件查找（Example 查找）

- 使用场景：当普通查找无法满足条件的时候，需要查找的数据，有太多的条件的时候
- 使用示例：
- 缺点：不支持投影。如果遇到需要投影的场景必须要使用原生的api实现

- 了解ExampleMatcher



## 1.3.sort 排序

- 功能：根据某一列进行排序
- 缺点：
  - 无法根据聚合的列进行排序。例如 根据语文考试，数学考试成绩的总和进行排序。
  - 此外不支持和@Query中的nativeQuery一起使用，但是可以和其他的Named parameters一起用
- 默认的排序是ASC （升序排列）
- 升级使用类型安全的排序TypeSafeSort
- 如果要调用某个函数对sort进行排序，可以使用JpaSort.unsafeSort()

## 1.4.page 分页

- 传入一个参数为Pageable Pageable的对象，通常是PageRequest.
- PageRequeset 需要传入页面号从0开始，以及页面的大小，可以选择是否需要排序
- 返回的对象：Page<S> 
  - Page包含有数据库页面总数，数据库元素总个数
  - Page的父类有slice，理解为一个页面。当前页数据，当前页数据的个数，当前页的大小，当前页的序号

## 1.5.limit 个数

- 使用findFirst 或者findTop
- 默认：1个
- 查找10个，使用findFirst10或者findTop10
- **jpa不支持动态的传入limit来查询，可以使用分页查询来替代，查询第一页，页面大小为limit的数据**

## 1.6自定义查找

### 1.6.1 使用JPQL

- 使用场景：以上的内容都是由jpa自动生成sql语句，产生的sql语句可能会对数据库造成性能问题
- 使用示例：
  1. 原生JPQL: 需要写一个sql.表名需要自己写，变量用?1，?2表示 
     - 缺点：可读性差
  2. Name Parameters：变量可以使用:lastname代替，可读性上升，但是需要给参数一个@Param参数
  3. Name Parameters + SPEL: 2.1之后引入了新的SPEL。 表名可以通过SPEL来显示
- 主要的难点，如何传值给sql的语句

### 1.6.2 使用Native SQL（原生sql）

- 使用场景：不知道。不建议使用

- 缺点：
  1. native不支持基于DTO的投影
  2. native sql 不支持排序

# 2.insert

## 2.1 普通插入

- 原生api提供了save方法

## 2.2 动态插入

- @DynamicInsert 只插入不为空的值，其实没有多大的作用，数据库都会设置默认值，不然插入不进入

# 3.update

## 3.1 普通更新

- 原生api提供了save方法

## 3.2 自定义更新

- @Query + @Modify 方法

## 3.3 动态更新

- @DynamicUpdate 只更新不为null的值

# 4.delete

## 4.1普通删除

- 原生api的删除delete

## 4.2自定义删除

- @Query + @Delete

# 5.入参

## 5.1入参的形式

- Example
- T (对应的实体类)
- 实体类对应的属性
- 分页
- 排序
- Specification

## 5.2入参的校验

# 6.返回值

- T 不建议直接返回T对象，可能存在null指针的问题。

- Optional<T> 
- Collection<T> List<T> Set<T> 
- Iterable<T> 不建议使用 Iterator 不建议使用
- Stream<T>  更加建议返回Stramable
- Streamable<T>  
- Slice<T> 不建议使用，建议使用Page<T>
- Page<T>
- 王炸：投影 简单来说是返回一部分的内容
  - 值得说明的是Streamable<T> 的特殊用法和投影很像
  - 区别：Streamable<T> 可以进行复杂的计算，不是简单的对象。其他的程序也不是很好用的样子
    - 投影可以利用简单的对象返回子对象，可以进行简单的计算。返回的bean简单，容易理解，可以设置权限。
  - 投影分类
    - 基于接口的投影（需要定义接口）
      - 封闭投影（指接口定义的属性是对象的子集）
      - 开放投影（接口定义的属性可以是派生的属性）
    - 基于类的投影 简称DTO（目前还没有测试，不可以和排序功能一起用。派生的属性直接定义方法就好了。直接get就好了）
    - 动态投影。
      - 和上述的区别是，如果定义了一个方法，返回固定类型的值，就绑定了
      - 如果传入一个Class<T> 那么返回值用泛型表示，就定义了一个动态的投影的功能。
      - 简单言之，动态投影综合了接口投影和类的投影。




