package model;
import java.util.Date;

import javax.persistence.*;


@MappedSuperclass
public class BaseEntityBean {

	

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		 Integer id;

		

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}


		
		
		
	}

