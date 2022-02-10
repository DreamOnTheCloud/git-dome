package ShapePackage;
//定义形状类里面各个形状对应的属性和有两个抽象方法
public abstract class Shape {
    private float width;  //宽度
    private float length; //高度
    private float r;      //半径
    /**
     * 他们每个形状的值所对应的构造方法
     * 无参的和对应的
     */
    public Shape(){

    }

    //针对矩形的构造方法(包含长和宽)
    public Shape(float width , float length){
        this.length = length;
        this.width = width;
    }

    //针对圆的构造方法(包含半径)
    public Shape(float r){
        this.r = r;
    }

    //设置与获取上面成员变量的值的方法
    public void setWidth(float width){
        this.width = width;
    }

    public float getWidth(){
        return width;
    }

    public void setLength(float length){
        this.length = length;
    }

    public float getLength(){
        return length;
    }

    public void setR(float r){
        this.r = r;
    }

    public float getR(){
        return r;
    }

    //最后两个抽象方法
    public abstract float area ();  //求面积方法
    public abstract float circumference(); //求周长方法

}

//定义圆类要实现以上方法的类
class circle extends Shape {
    //子类的无参构造方法
    public circle(){

    }

    //子类的构造方法
    public circle(float r){
        super(r);
    }

    //实现求面积的方法
    public float area(){
        float Area = (float) (3.14 * Math.pow(getR() , 2));
        return Area;
    }

    //实现求周长的方法
    public float circumference(){
        float circumference = (float) (3.14 * 2 * getR());
        return circumference;
    }
}


//定义正方形类实现以上类
class square extends Shape{
    //正方形无参构造方法
    public square(){

    }

    //正方型带参构造方法
    public square(float width , float length){
        super(width , length);
    }

    //求正方形面积方法
    public float area(){
        Float area = (float)(Math.pow(getWidth(),2));
        return area;
    }

    //求正方形周长方法
    public float circumference(){
        Float circumference = (float) (getWidth() * 4);
        return circumference;
    }
}

//定义正方形类实现以上类
class rectangle extends Shape{
    //正方形无参构造方法
    public rectangle(){

    }

    //正方型带参构造方法
    public rectangle(float width , float length){
        super(width , length);
    }

    //求正方形面积方法
    public float area(){
        Float area = (float) getLength() * getWidth();
        return area;
    }

    //求正方形周长方法
    public float circumference(){
        Float circumference = (float) (getWidth() + getLength()) * 2;
        return circumference;
    }
}

//形状类的最终实现
class test1{
    public static void main(String[] args) {
        //c1针对圆形有参构造方法
        Shape c1 = new circle(8);
        System.out.println("圆的面积" + c1.area());
        System.out.println("圆的周长" + c1.circumference());
        //c2针对圆形无参构造方法
        Shape c2 = new circle();
        c2.setR(60);
        System.out.println("圆的面积" + c2.area());
        System.out.println("圆的周长" + c2.circumference());


        //s1针对正方形有参构造方法
        Shape s1 = new square(16,20);
        System.out.println("正方型的面积" + s1.area());
        System.out.println("正方型的周长" + s1.circumference());

        Shape r1 = new rectangle(4,5);
        System.out.println("长方型的面积" + r1.area());
        System.out.println("长方型的周长" + r1.circumference());

    }
}














