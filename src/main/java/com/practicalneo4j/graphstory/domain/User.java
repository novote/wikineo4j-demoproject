package com.practicalneo4j.graphstory.domain;

import java.util.Set;



import org.springframework.data.annotation.TypeAlias;
//import org.springframework.data.neo4j.annotation.GraphId;
//import org.springframework.data.neo4j.annotation.Indexed; //not suported
//import org.springframework.data.neo4j.annotation.NodeEntity;
//import org.springframework.data.neo4j.annotation.RelatedTo;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;



import java.text.SimpleDateFormat;
import java.util.Date;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashSet;

import javax.validation.constraints.Size;
import javax.validation.constraints.*;

import java.util.Set;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
//import org.hibernate.validator.constraints.*;
//import com.practicalneo4j.graphstory.service.main.validator.ValidEmail;


//for Spring securety UserDetails
import com.fasterxml.jackson.annotation.JsonIgnore;

///import javax.persistence.Entity;
//import javax.persistence.Id;


//import com.practicalneo4j.securityconf.Authority;
import org.neo4j.ogm.annotation.Transient;

import org.springframework.format.annotation.DateTimeFormat;
;

@NodeEntity
@TypeAlias("User")

// public class User implements UserDetails
public class User extends Entity 

  {

    @JsonProperty("id")
    private Long id;
	
	//@GraphId  used
	private Long nodeId;

   //@Indexed //???? delte not used
	//private String user;
	private String userNodeId;
	//test validation
	
	@Email
	@Pattern(regexp=".+@.+\\.[a-z]+")
//	@ValidEmail
	@NotNull
	@NotEmpty(message = "Please enter your .")
	private String useremail;
	
	private boolean useremailPrivacy;  //for privacy setting show/hide 
	
	

	//@Min(0)  ??????  Not User it
	@NotEmpty(message = "Please enter your password.")
	@Size(min = 4, max = 15, message = "Your password must between 4 and 15 characters")
	private String userpassword;
    
	//--------------------------------------------------------------
	
	private String occupation;               // job profession of user
	private String aboutYuorself;            // some words about yuorself /self presentation
	private String fotoLocalUrl;             // foto /avatar  with data on server onli jpeg
	private String langKey;                  // local interface          
	private String sex;                      // sex 
	private String birthday;                 //  day of birthday   >>> sring OR timestamp
	private Set<String> interest;           // user interest keyword   >>>???? list OR link ?????
	private String firstname;
    private String lastname;
    private  int   reputation;
    private  int   gainPrizePoint;           //accamulete  km of event
    private String residention;              //user live in  by address. take it from HAS relationship
    private  int   commentCount;             //for public profile page  all user vote for post of user

	
	private String dateRegistrationAccount;  //user registration with time ???
	private Long   timestamp;                //time of registration of user
	@Transient
	private String timestampAsStr;           //time of registration of user like string value
	
	//--------------------------------------------------------------

	//@Indexed
	// uses CREATE INDEX ON :User(username);
	
	@NotNull
	@NotEmpty(message = "Please enter your .")
	@Size(min = 4, max = 15, message = "Your name must between 4 and 15 characters")
	private String username;
	@NotNull
	@NotEmpty(message = "Please enter your .")
	private String password;
	@NotNull
	@NotEmpty(message = "Please enter your .")
	private String passwordConfirm;
	
	// for REST registration (if it posible identify?? ) IMEI iOS devises
	private String divaiceId;
	
	
	private boolean enabled; // put account active for spring securety filter
	
	@JsonIgnore  //chack activation key account with email
	@Size(max = 20)
    private String activationKey;
	
	     @Transient
	     private String confirmedPassword;
	 
//---------------------------------------------------------------

	     private Set<String> authorities;  // right of moderation on the site    // private Set<Authority> authorities = new HashSet<>();
	
	     private Set<String> categoryOfmoderationName;  // category name for User have the right to moderation on the site

//----------------------------------------------------------------	

	
	    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	    private Date createdate;

	    @Relationship(type = "USES", direction = Relationship.OUTGOING)
	    private Set<Tag> tags;
	
        public User( ) { 
		  
		  this.tags = new HashSet<>();
   
	    }
	

	    public User User( String username, String password, boolean isEnabled,  Set<String> authorities)
	   {
		this.username = username;
		this.password = password;
		this.authorities = authorities;
		
	    return 	 this;
	    }

		public Set<String> getAuthorities() {
			return authorities;
		}

		public void setAuthorities(Set<String> authorities) {
			this.authorities = authorities;
		}
 
	public Long getNodeId() {
		return nodeId;
	}

	public void setNodeId(Long nodeId) {
		this.nodeId = nodeId;
	}

   public String getUserNodeId() {
		return userNodeId;
	}

	public void setUserNodeId(String userNodeId) {
		this.userNodeId = userNodeId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Set<Tag> getTags() {
		return tags;
	}

	public void setTags(Set<Tag> tags) {
		this.tags = tags;
	}


	public String getResidention() {
		return residention;
	}

	public void setResidention(String residention) {
		this.residention = residention;
	}

	public String getUseremail() {
		return useremail;
	}

	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}

	public String getUserpassword() {
		return userpassword;
	}

	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}
	
	    public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public boolean isUseremailPrivacy() {
		return useremailPrivacy;
	    }

	    public void setUseremailPrivacy(boolean useremailPrivacy) {
		this.useremailPrivacy = useremailPrivacy;
	    }

	    public Long getId() {
	        return id;
	    }
	
		public void setId(Long id) {
	        this.id = id;
	    }

    	public String getPasswordConfirm() {
			return passwordConfirm;
		}
		public void setPasswordConfirm(String passwordConfirm) {
			this.passwordConfirm = passwordConfirm;
		}

	    public String getConfirmedPassword() {
			return confirmedPassword;
		}
		public void setConfirmedPassword(String confirmedPassword) {
			this.confirmedPassword = confirmedPassword;
		}
		
		public String getSex() {
			return sex;
		}
		public void setSex(String sex) {
			this.sex = sex;
		}
		
		
		public String getBirthday() {
			return birthday;
		}

		public void setBirthday(String birthday) {
			this.birthday = birthday;
		}

		public Set<String> getInterest() {
			return interest;
		}

		public void setInterest(Set<String> interest) {
			this.interest = interest;
		}
		
		

		public Date getCreatedate() {
			return createdate;
		}
		
		public void setCreatedate(Date createdate) {
			this.createdate = createdate;
		}
	  
	    public String getLangKey() {
			return langKey;
		}
		public void setLangKey(String langKey) {
			this.langKey = langKey;
		}
		

	    public String getActivationKey() {
			return activationKey;
		}
		public void setActivationKey(String activationKey) {
			this.activationKey = activationKey;
		}
	
    	public int getReputation() {
			return reputation;
		}
		public void setReputation(int reputation) {
			this.reputation = reputation;
		}
		
	    public String getDivaiceId() {
			return divaiceId;
		}
		public void setDivaiceId(String divaiceId) {
			this.divaiceId = divaiceId;
		}
	//not add email and pass 
	@Override
    public String toString() {
        return "User{" +
               "id=" + getId() +
                ", username='" + username + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", authorities='" + authorities + '\'' +
                ", reputation='" + reputation + '\'' +
                ", enabled='" + enabled + '\'' +
                ", tags=" + tags.size() +
              
                '}';
    }
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public String getAboutYuorself() {
		return aboutYuorself;
	}
	public void setAboutYuorself(String aboutYuorself) {
		this.aboutYuorself = aboutYuorself;
	}
	public String getFotoLocalUrl() {
		return fotoLocalUrl;
	}
	public void setFotoLocalUrl(String fotoLocalUrl) {
		this.fotoLocalUrl = fotoLocalUrl;
	}
	
	public int getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
	}

	public String getDateRegistrationAccount() {
		return dateRegistrationAccount;
	}
	public void setDateRegistrationAccount(String dateRegistrationAccount) {
		this.dateRegistrationAccount = dateRegistrationAccount;
	}
	public Long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	
	

	public int getGainPrizePoint() {
		return gainPrizePoint;
	}

	public void setGainPrizePoint(int gainPrizePoint) {
		this.gainPrizePoint = gainPrizePoint;
	}

	public Set<String> getCategoryOfmoderationName() {
		return categoryOfmoderationName;
	}

	public void setCategoryOfmoderationName(Set<String> categoryOfmoderationName) {
		this.categoryOfmoderationName = categoryOfmoderationName;
	}

	public String getTimestampAsStr() {
		if (timestamp != null)
		{
			Date d = new Date(Long.valueOf(timestamp * 1000));
			SimpleDateFormat dformatter = new SimpleDateFormat("MM/dd/yyyy");
			SimpleDateFormat tformatter = new SimpleDateFormat("h:mm a");
			timestampAsStr = dformatter.format(d) + " at " + tformatter.format(d);
		}
		return timestampAsStr;
	}
	
	
	

}