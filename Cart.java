import java.util.*;
class Cart
{
  /*-----------------------------
 
  	To add Elements in Cart

  -----------------------------*/
  
  public static void addtoCart(Map<String,Integer> itemsstock,Map<String,Integer> itemsprice,Map<String,Integer> cart)
  {
    Scanner in=new Scanner(System.in);
    System.out.println("Enter Product Name ");
    String str=in.nextLine();
    if(!itemsstock.containsKey(str))
    {
      System.out.println("Element Not Found");
    }
    else
    {
      System.out.println("Enter Number of Elements");
      Integer numberofItem=in.nextInt();
      if(numberofItem>itemsstock.get(str))
      {
        System.out.println("Number of Elements not Available ");
      }
      else
      {
        cart.put(str,numberofItem*itemsprice.get(str));
        itemsstock.replace(str,itemsstock.get(str)-numberofItem);
      }
    }
  }
  
  
  /*--------------------------------

  	To Remove an Element

  --------------------------------*/

   public static void removefromCart(Map<String,Integer> itemsstock,Map<String,Integer> itemsprice,Map<String,Integer> Cart)
   {
     Scanner sc=new Scanner(System.in);
     System.out.println("Enter Product Name ");
     String s=sc.nextLine();
     if(!Cart.containsKey(s))
     {
       System.out.println("Element Not Found ");
     }
     else
     {
       System.out.println("Enter Number of Elements ");
       Integer numberofItems=sc.nextInt();
       if(numberofItems>Cart.get(s))
       {
         System.out.println("Enter Value Correctly ");
       }
       else
       {
         Cart.replace(s,Cart.get(s)-(numberofItems*itemsprice.get(s)));
         itemsstock.replace(s,itemsstock.get(s)+numberofItems);
       }
     }
   }


   /*--------------------------------

  	To Display the Cart

  --------------------------------*/
 
  public static void Display(Map<String,Integer> Cart)
  {
    for(Map.Entry<String,Integer> entry:Cart.entrySet())
    	System.out.println("Product : "+entry.getKey()+"  Price : "+entry.getValue());
  }	  
  
	
  public static void main(String...arg)
  {
    Map<String,Integer> itemsstock=new HashMap<String,Integer>();
    Map<String,Integer> itemsprice=new HashMap<String,Integer>();

    Scanner sc=new Scanner(System.in);
    Integer i;
    itemsstock.put("Soap",10);
    itemsstock.put("Milk",20);
    itemsstock.put("Dettol",10);
    itemsstock.put("Perfume",25);

    itemsprice.put("Soap",30);
    itemsprice.put("Milk",50);
    itemsprice.put("Dettol",45);
    itemsprice.put("Perfume",37);

    Map<String,Integer> cart=new HashMap<String,Integer>();
    String url;	
    do
    { 
      for(Map.Entry<String,Integer> entry:itemsstock.entrySet())
    	System.out.println(entry.getKey()+"  :  "+entry.getValue());
      
      System.out.println("1.  Add Elements in Cart");
      System.out.println("2.  Remove Elements in Cart");
      System.out.println("3.  Display the Cart ");   
      System.out.println("Enter Choice (1/2/3)");
      i=sc.nextInt();
      if(i==1)
      {
        addtoCart(itemsstock,itemsprice,cart);
      }
      else if(i==2)
      {
        removefromCart(itemsstock,itemsprice,cart);
      }
      else if(i==3)
      {
        Display(cart);
      }
      else
      {
        System.out.println("Invalid Choice --  ");
      }
      	
      System.out.println("Do You Want to Continue ?(Y/N)");
      url=sc.next();
      
    }while(url.equals("Y") || url.equals("y"));

    int sum=0;
    for(Map.Entry ele:cart.entrySet())
    {
      int val=((int)ele.getValue());
      sum=sum+val;
    }

   

    System.out.println("Total Amount "+sum);
     

  }
}
    
    