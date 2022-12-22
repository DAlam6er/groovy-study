package com.dmdev.lesson21

class MopRunner {
    // в байткоде будет проксирование метода println() через метакласс:
    // CallSite[] var1 = $getCallSiteArray()
    // var1[0].callStatic(MopRunner.class, "Hello")
    static void main(String[] args) {
        println "Hello"
    }
}
