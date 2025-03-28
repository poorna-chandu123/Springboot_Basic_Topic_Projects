/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Opps_Polymorphism_topic;

/**
 *
 * @author annapureddy.chandu
 */
public class Overridding_2 extends Overriding {
    
    @Override  // E @override ani evvatam valla same parent class lo vunna vidamgane method name ni rasthunnamo ledo java ne check chesukuntadi
     public void add(){
        System.out.println("chiled class add");
        
        super.copy();
    }
     
   @Override
    public  void copy(){  //  public void copy(int a) ani eisthe @override kada Error vasthundi 
         System.out.println("chiled class copy");
         
         super.add(); // eila ne rasukogalamu Main method lo rayalemu but Static method's ni call cheyachhu
    }
    
  //   @Override cheyaemu but kavali ante same name tho create chesukovachhu
      public  static void pic(){
         System.out.println("chaild  class pic");
         
        // Overriding.pic(); // super key word anedi only instances method ki kanuka static methods ki parentclass lovi pilavali ante class name vadali 
      }
    
    
    public static void main(String[] args) {
        
        Overridding_2 s =new Overridding_2();
        
        s.add();
        s.copy();
        
        System.out.println("=================================");
        s.pic();
        
       //  super.add(); // vitini direcct ga main method lo rayalemu so, vitini chiled class loni methods lo rasukoni print chesukovali
       // super.copy();
       
       
       /*   
       ==== Key Points: ====
1)Polymorphism only works with instance methods, not static methods.
2)Static methods are resolved at compile-time based on the reference type, not the object type.
3)super can only be used in instance methods, not static methods.
       
4)Static methods are not polymorphic. This means that the method is called based on the reference type, not the object type.
5)When you call a static method using a reference (e.g., s.pic()), Java will look at the reference type (Overriding in this case) and call the static method from that class, not from the object’s class (Overridding_2).
       
       Overriding s = new Overridding_2();
           s.pic();
6)Here, s is a reference of type Overriding, so s.pic() will call the pic() method from the Overriding class, not from Overridding_2.
7)As a result, only the parent class's pic() method will be executed, and it won't print the child class's pic() method output.
       
       
       
       */
       
       
       
       
    }
    
}
