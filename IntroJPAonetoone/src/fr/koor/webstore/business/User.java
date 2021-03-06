package fr.koor.webstore.business;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity @Table(name = "T_Users")
public class User {

    @Id  @GeneratedValue( strategy=GenerationType.IDENTITY )
    private int idUser;
    
    private String login;
    
    private String password;
    
    private int connectionNumber;
    
    @OneToOne  
    @JoinColumn( name="idUserInformations", nullable=false )
    private UserInformations userInformations;
    

    public User() { }
    
    public User( String login, String password, int connectionNumber ) {
        super();
        this.setLogin( login );
        this.setPassword( password );
        this.setConnectionNumber( connectionNumber );
    }

    
    public int getIdUser() {
        return idUser;
    }
    
    public String getLogin() {
        return login;
    }
    
    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public int getConnectionNumber() {
        return connectionNumber;
    }
    
    public void setConnectionNumber(int connectionNumber) {
        this.connectionNumber = connectionNumber;
    }
    
    public UserInformations getUserInformations() {
        return userInformations;
    }

    public void setUserInformations(UserInformations userInfos) {
        this.userInformations = userInfos;
    }

    
    public String toString() {
        return this.idUser + ": " + this.login + "/" + this.password 
             + " - " + this.connectionNumber + " connexion(s)";
    }
    
}