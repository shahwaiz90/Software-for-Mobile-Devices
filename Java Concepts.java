/*
Roll No: 15l-4172 | Name: Talha Saqib
Scenerio: FoodMaker is a machine for making a certain food, one of which is a Special Beef Burger. All FoodMakers share same manufacturer and that cannot be changed. Also, every maker has just one mechanic for its maintenance, however it can be replaced with some other. For each FoodMaker, there is a model and its operator. FoodMaker can continously make food until it runs out of quantity.  
*/



abstract class FoodMaker
{
    final static public String manufacturer = "Toshiba";			//same for all FoodMakers
    public static String mechanic = "Julien Sam";					//same for all FoodMakers but can be changed
    private int model;
    private String operator;
    
    FoodMaker(){}
    
    FoodMaker(int m, String op)
    {
        model = m;
        operator = op;
    }
    
    public void checkModel()
    {
        System.out.println("Model: "+ model);
    }
    
    public void checkOperator()
    {
        System.out.println("Operator: "+ operator);
    }
    
    public static void updateMechanic(String m)
    {
        mechanic = m;
    }
    
    public abstract void makeFood();
}

interface Buns { public void addBuns(); }
interface Mustard { public void addMustard(); }
interface Beef { public void addBeef(); }

//Custom Exception
class NoQuantityLeftException extends Exception
{
      public NoQuantityLeftException() {}

      public NoQuantityLeftException(String message)
      {
         super(message);
      }
 }


class MakeSpecialBeefBurger extends FoodMaker implements Buns, Mustard, Beef
{
    public static int quantity_left = 2;
    MakeSpecialBeefBurger.Quantity quantityObj = new  MakeSpecialBeefBurger.Quantity();         //Inner Static Class Object
    Wrapper wrap = new Wrapper();           //Inner Simple Class Object
    
    MakeSpecialBeefBurger(){}
    
    MakeSpecialBeefBurger(int m, String op)
    {
        super(m, op);
    }
    
    public void addBuns()
    {
        System.out.println("2 Buns added for Special Beef Burger");
    }
    
    public void addMustard()
    {
        System.out.println("Mustard added to Special Beef Burger");
    }
    
    public void addBeef()
    {
        System.out.println("Special Beef Patty added to Special Beef Burger");
    }
    
    public void checkQuantity()
    {
         quantityObj.checkQuantity();
    }
    
    public void makeFood()
    {
        try
        {
            if(quantity_left <= 0)
            {
                throw new NoQuantityLeftException();
            }
            else
            {
                addBuns();
                addMustard();
                addBeef();
                
                wrap.addWrapper();
                quantityObj.updateQuantity();
                
            }
        }
        catch(NoQuantityLeftException e)
        {
            System.out.println("There is no Special Beef Burger left!");
        }
        finally
        {
            return;
        }
    }
    
    static final class Quantity
    {
        public void checkQuantity()
        {
            System.out.println("Quantity Left for SBB: " + quantity_left);
        }
        
        public void updateQuantity()
        {
            try
            {
                quantity_left--;
            }
            catch(Exception e)              //General Exception Handling; could be checked or unchecked exception
            {
                System.out.println("Exception found!");
            }
        }
    }
    
    final class Wrapper                     //This class would not need to be inherited; hence final
    {
         public void addWrapper()
         {
             System.out.println("Special Beef Burger is packed and ready to deliver!");
         }
    }
}


public class MainClass
{
     public static void main(String []args)
     {
        System.out.println("Mechanic: " + FoodMaker.mechanic);              //static variable
        System.out.println("Manufacturer: " + FoodMaker.manufacturer);      //final static variable
         
        MakeSpecialBeefBurger specialBeefBurger = new MakeSpecialBeefBurger(54, "Marco");       //FoodMaker1
        specialBeefBurger.makeFood();
        specialBeefBurger.checkQuantity();
        specialBeefBurger.checkModel();
        specialBeefBurger.checkOperator();
        specialBeefBurger.updateMechanic("Salsa");                          //mechanic is replaced here for all FoodMakers
        System.out.println("Mechanic: " + FoodMaker.mechanic);
        
        MakeSpecialBeefBurger specialBeefBurger1 = new MakeSpecialBeefBurger(4, "Phil");         //FoodMaker2
        specialBeefBurger1.makeFood();
        specialBeefBurger1.checkQuantity();
        specialBeefBurger1.checkModel();
        specialBeefBurger1.checkOperator();
      
        specialBeefBurger1.makeFood();                  //At this point quantity = 0, so no burger should be made
        
     }
}