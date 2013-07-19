package org.mobileapi.helper;

public class Validator {

	 public boolean IsEmail(String email)
     {
         if (email == null || email.length() < 5 || email.length() > 70)
         {
             return false;
         }
         if (email.indexOf('@') < 0)
         {
             return false;
         }
         if (email.indexOf('.') < 0)
         {
             return false;
         }
         try
         {
            // MailAddress m = new MailAddress(email);
         }
         catch(Exception e)
         {
             return false;
         }
         return true;
     }

     public boolean IsPin(String pin)
     {
         if (pin==null || pin.length() < 6 || pin.length() > 12)
         {
             return false;
         }
         return true;
     }

     // TODO define passwort policy
     public boolean IsPasswort(String pwd)
     {
         if (pwd == null || pwd.length() < 8 || pwd.length() > 30)
         {
             return false;
         }
         return true;
     }

     public boolean IsNewPasswort(String pwd, String repeat)
     {
         if (!IsPasswort(pwd))
         {
             return false;
         }
         if (!pwd.equals(repeat))
         {
             return false;
         }
         return true;
     }

     public boolean IsUpdatePasswort(String oldPwd, String pwd, String repeat)
     {
         if (!IsPasswort(pwd))
         {
             return false;
         }
         if (!pwd.equals(repeat))
         {
             return false;
         }
         if (oldPwd.equals(pwd)) // is passwort new
         {
             return false;
         }
         return true;
     }

     public boolean IsAppName(String name)
     {
         if (name == null || name.length() < 3 || name.length() > 50)
         {
             return false;
         }
         return true;
     }

     public boolean IsAddressField(String field)
     {
         if (field == null || field.length() > 50)
         {
             return false;
         }
         return true;
     }

     public boolean IsDesc(String desc)
     {
         if (desc == null || desc.length() > 4096)
         {
             return false;
         }
         return true;
     }
}
