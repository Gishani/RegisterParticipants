/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package techday;

/**
 *
 * @author gishanir
 */
public class Employee implements Comparable<Employee>{
    
    private String emailID;
    private String name;
    private String product;
    private boolean registration;
    private int registrationNo;

    /**
     * @return the emailID
     */
    public String getEmailID() {
        return emailID;
    }

    /**
     * @param emailID the emailID to set
     */
    public void setEmailID(String emailID) {
        this.emailID = emailID;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the product
     */
    public String getProduct() {
        return product;
    }

    /**
     * @param product the product to set
     */
    public void setProduct(String product) {
        this.product = product;
    }

    /**
     * @return the registration
     */
    public boolean getRegistration() {
        return registration;
    }

    /**
     * @param registration the registration to set
     */
    public void setRegistration(boolean registration) {
        this.registration = registration;
    }

    /**
     * @return the registrationNo
     */
    public int getRegistrationNo() {
        return registrationNo;
    }

    /**
     * @param registrationNo the registrationNo to set
     */
    public void setRegistrationNo(int registrationNo) {
        this.registrationNo = registrationNo;
    }

    @Override
    public int compareTo(Employee e) {
        int a = this.getEmailID().compareTo(e.getEmailID());
        int b = e.getEmailID().compareTo(this.getEmailID());
        
        return ((a<b)? -1:(b<a)?1:0);
    }
    
    /*void search(String a,String b){
        if(a.startsWith(b)){
            
        }
    }*/
}
