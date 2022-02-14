* 初始化方法在构造器执行之后执行
* 销毁方法在对象销毁之前调用

## @Autowired ,@Qualifier,@Resource区别
* @Autowired:按照类型进行自动装配
* @Qualifier:对于@Autowired按照类型进行装配在容器中找到多个可装配类型Bean时,指定BeanName就行装配,经常和@Autowired搭配使用
* @Resource:默认装配方式为ByName,如果没有找到对应BeanName,则在容器中找可以注入的类型装配,如果还找不到,报错

## 动态代理
* jdk动态代理:通过被代理类实现的接口创建代理对象,需要被代理类实现接口
* cglib动态代理:通过创建被代理类的子类来创建代理对象,被代理类无需实现接口 不能对final修饰的类产生代理对象

## aop:面向切面编程

![](images/aop_process.jpg)

* 连接点(JoinPoint):所有类的方法
* 切入点(PointCut):真正被增强的方法
* 通知(也有称之为增强):放在切入点前面或者后面的执行逻辑
* 切点: 实现增强功能的方法逻辑
* 切面: 定义切点方法的类 
* 增强: 在切入点织入切点

注意:
* 如果要使用spring aop面向切面编程,调用切入点方法的对象必须通过spring容器获取
* 如果一个类的方法被声明为切入点并且织入了切点之后,通过spring容器获取该类对象,实则是一个代理对象
* 如果一个类中的方法没有声明为切入点,通过spring容器获取的这个类对象就是spring容器通过反射创建的对象

## AOP的通知策略(如何将切点织入切入点)
* before
* after
* afterReturning
* afterThrowing
* around