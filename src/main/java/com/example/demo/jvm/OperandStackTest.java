package com.example.demo.jvm;

/**
 * 测试i++与++i的区别
 *  0 iconst_0:将int常量0加载到操作数栈里（入栈）
 *  1 istore_1:将操作数栈的数值加载到局部变量表索引为1的位置
 *  2 iload_1:将局部变量表索引为1的值加载到操作数栈里
 *  3 iinc 1 by 1:局部变量表索引为1的值加1(当前局部变量表i1为1)
 *  6 istore_1:将操作数栈的数值加载到局部变量表（局部变量表i1的值从1变为0）
 *  7 getstatic #5 <java/lang/System.out>:获取System类字段out
 * 10 iload_1:将局部变量表索引为1的值加载到操作数栈里
 * 11 invokevirtual #6 <java/io/PrintStream.println>:调用PrintStream对象的实例方法println
 * 14 iconst_0:将int常量0加载到操作数栈里（入栈）
 * 15 istore_2:将操作数栈的数值加载到局部变量表索引为2的位置
 * 16 iinc 2 by 1:局部变量表索引为2的值加1(当前局部变量表i2为1)
 * 19 iload_2:将局部变量表索引为2的值加载到操作数栈里
 * 20 istore_2:将操作数栈的数值加载到局部变量表索引为2的位置（局部变量表i2的值从0变为1）
 * 21 getstatic #5 <java/lang/System.out>
 * 24 iload_2
 * 25 invokevirtual #6 <java/io/PrintStream.println>
 * 28 return
 *
 *
 * 重点：方法的调用：解析和分派
 */
public class OperandStackTest {
    public static void main(String[] args) {
        OperandStackTest operandStackTest = new OperandStackTest();
        operandStackTest.test();
    }

    public void test(){
        int i1 = 0;
        i1 = i1++;
        System.out.println(i1);
        int i2 = 0;
        i2 = ++i2;
        System.out.println(i2);
    }
}
