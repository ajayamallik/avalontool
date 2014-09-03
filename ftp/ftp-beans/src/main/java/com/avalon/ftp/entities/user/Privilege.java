
package com.avalon.ftp.entities.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="privilege")
public class Privilege {
    
    @Id
    @Column(name="privilege_id",insertable=false,updatable=false)
    private int privilegeId;
    
    
    private String name;
    
     
    public Privilege() {

    }
    
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
