package com.avalon.ftp.beans.user;

import org.hibernate.validator.constraints.NotEmpty;

public class PrivilegeBean {
	

    private int privilegeId;    
    
    @NotEmpty(message="Privilege Name  is required")
    private String name;    

    
    public int getPrivilegeId() {

        return privilegeId;
    }
    
    public void setPrivilegeId(int privilegeIdObj) {

        this.privilegeId = privilegeIdObj;
    }
    
    public String getName() {

        return name;
    }
    
    public void setName(String nameObj) {

        this.name = nameObj;
    }
    
        
     
      
}



