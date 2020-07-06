

## 自定义事件和事件监听器

1.自定义事件：扩展ApplicationEvent类，需要有构造函数。

2.自定义事件监听器：实现ApplicationListener接口，重写onApplicationEvent方法，该方法处理监听到某个事件后做哪些操作。

3.通过ApplicationContext发布事件
