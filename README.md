Android相关知识示例：

1.对Handler理解示例。写一个小例子实现handler的功能，子线程发消息通知UI线程更新UI。

2.Android事件传递机制理解示例

![事件分发图解](https://github.com/tomyZhou/ADemo/blob/master/mm.jpg)



dispatchTouchEvent方法是负责决定是否向下分发事件，由上往下。onTouchEvent方法是对事件进行处理的方法，由下往上。onInterceptTouchEvent方法是ViewGroup类型控件独有的，它的作用是决定是不是拦截当前事件。

      dispatchTouchEvent方法返回结果的情况：

               true：事件直接结束。

               false：如果是Activity的dispatchTouchEvent方法，事件结束，否则事件回到到父控件，这时父控件调用onTouchEvent         方法处理事件。

               super：如果是Activity的dispatchTouchEvent方法，调用父类的dispatchTouchEvent方法之后，事件将会传递到子View的dispatchTouchEvent方法。如果是ViewGroup的dispatchTouchEvent方法，则会调用自身的onInterceptTouchEvent方法，以判断是不是需要对事件进行拦截。如果是View的dispatchTouchEvent方法，事件会交给自身的onTouchEvent方法来处理。

        onTouchEvent方法返回：

             对于Activity来说，如果事件重新回到它的onTouchEvent方法，就说明它下面所有的View都没有处理这个事件，最终把事件又抛回来给它了，所以在它的onTouchEvent事件中，不管最终在这个方法中的结果如何，都直接结束事件。

              true/super：表示当前View处理这个事件，方法结束之后，事件也就结束了。

              false：事件将会被抛回父控件，然后父控件调用onTouchEvent方法来看是不是要处理事件。

       onInterceptTouchEvent方法返回：

             true：表示当前控件要拦截事件，紧接着事件交给当前控件的onTouchEvent方法来处理。

            super/false：不拦截事件，事件最终继续往下分发。

另外还要交待的情况：

   有点击事件的View默认的super.ontouchEvent(event) 其实返回的是true
   没有点击事件的ViewGroup的super.onTouchEvent(event)其实返回的是false
   
下面就是将View 的onTouchEvent返回false,ViewGroup的onTouchEvent使用super.onTouchEvent(event)时的打印结果：

2019-12-03 14:40:53.884 17591-17591/  E/EventDemoActivity: EventDemoActivity dispatchTouchEvent

2019-12-03 14:40:53.885 17591-17591/  E/MyLayout: dispatchTouchEvent: ACTION_DOWN

2019-12-03 14:40:53.885 17591-17591/  E/MyButton: MyButton dispatchTouchEvent

2019-12-03 14:40:53.885 17591-17591/  E/MyButton: MyButton onTouchEvent

2019-12-03 14:40:53.886 17591-17591/  E/MyButton: true

2019-12-03 14:40:53.886 17591-17591/  E/MyButton: super.onTouchEvent(event)=true

2019-12-03 14:40:53.886 17591-17591/  E/MyButton: 设置成 false

2019-12-03 14:40:53.886 17591-17591/  E/MyLayout: onTouchEvent: ACTION_DOWN

2019-12-03 14:40:53.886 17591-17591/  E/MyLayout: super.onTouchEvent(event)=false

2019-12-03 14:40:53.886 17591-17591/  E/EventDemoActivity: EventDemoActivity onTouchevent
   
