package com.example.springboot.utils;



public class BaseDemo {
}


 interface demo<T>{

}

//类型的檫除 此时 T 就是 object 类型

class demoImpl1 implements demo{

}

//子类泛型 -- 父类泛型
class demoImpl2<T> implements  demo<T>{

}

//子类泛型 -- 父类檫除
class demoImpl3<T> implements demo{

}

//子类檫除 -- 父类泛型--------------错误

/*class demoImpl4 implements demo<T>{

}*/
