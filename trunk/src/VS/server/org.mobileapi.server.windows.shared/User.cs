using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace org.mobileapi.server.windows.shared
{
    public class User
    {
       public Guid ID	 
       {
           set; get;
       }

       public List<Guid> appIDS	 
       {
           set; get;
       }

       public String  Givenname	 
       {
           set; get;
       }

       public String  Name	 
       {
           set; get;
       }

       public String  Email	 
       {
           set; get;
       }

       public String  MSISDN	 
       {
           set; get;
       }

      public String  Pwd	 
      {
           set; get;
      }

      public String  Addr0	 
      {
           set; get;
      }
        
      public String  Addr1 
      {
           set; get;
      }

      public String  City 
      {
           set; get;
      }

        
      public String  Postcode 
      {
           set; get;
      }

      public String  County 
      {
           set; get;
      }

      public String  Country 
      {
           set; get;
      }

     public String  Language 
     {
           set; get;
     }

     public EnumUserStatus  Status 
     {
           set; get;
     }

     public Guid  Token 
     {
           set; get;
     }

     public DateTime  Update 
     {
           set; get;
     }

     public DateTime  Create 
     {
           set; get;
     }

    }
}
