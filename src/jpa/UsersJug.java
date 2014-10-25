package jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usersJug", schema = "jugkeyspace")
public class UsersJug {

	    @Id
	    private int user_key;

	    @Column(name="name")
	    private String name;
	    
	    @Column(name="email")
	    private String email;

		public int getUser_key() {
			return user_key;
		}

		public void setUser_key(int user_key) {this.user_key = user_key;}
		public String getName() {return name;}
		public void setName(String name) {this.name = name;}
		public String getEmail() {return email;}
		public void setEmail(String email) {this.email = email;}		
	}

