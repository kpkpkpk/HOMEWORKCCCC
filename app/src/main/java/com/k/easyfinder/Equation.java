package com.k.easyfinder;

public class Equation {
    private double a;//ax^2
    private double b;//bx
    private double c;//c
    private double x1;//-b+sqrt(D)/2a
    private double x2;//-b-sqrt(D)/2a
    private double discriminant;
    public Equation(double a,double b,double c){
        if(a<0){
            this.a=a*(-1);
            this.b=b*(-1);
            this.c=c*(-1);
        }else{
            this.a=a;
            this.b=b;
            this.c=c;
        }

    }

    public double getX1() {
        return x1;
    }
    public double getX2() {
        return x2;
    }
    //находим дискриминант по формуле
    private void setDiscriminant(){
        discriminant=b*b-4*a*c;//b^2-4ac
    }
    //нет необходимости искать корни если дискриминант отрицательный, данная функция проверяет неотрицательность
    private boolean checkDiscriminant(){
        if(discriminant<0){
            return false;
        }else{
            return true;
        }
    }
    //обычный геттер дискриминанта
    private double getDiscriminant(){
        return discriminant;
    }
    //далее тут сеттеры х1 и х2 по формуле -b+-sqrt(D)/2a
    private void setX1(){
        x1= (((-1)*b)+Math.sqrt(getDiscriminant()))/(2*a);//x1= -b+sqrt(D)/2a
    }
    private void setX2(){
       x2=(((-1)*b)-Math.sqrt(getDiscriminant()))/(2*a);
    }
    //вывод х1 и х2
    public String solve(){
        setDiscriminant();
        //смотри функцию checkDiscriminant();
        if(!checkDiscriminant()){
            return "no roots bro";
        }else{
            //нет смысла искать два корня, если дискриминант равен 0, т.к. квадратное уравнение скалдывается в полный квадрат
            if(getDiscriminant()==0){
                setX1();
                return "x1=x2="+getX1();
                //если же он больше ноля, то происходит поиск х1 и х2, далее вывод
            }else{
                setX1();
                setX2();
                return "x1= "+getX1()+"\n"+"x2= "+getX2();
            }
        }
    }
}

