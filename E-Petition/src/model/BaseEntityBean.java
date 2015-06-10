package model;

import javax.persistence.*;


@MappedSuperclass
public class BaseEntityBean {

	

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private Integer id;

		

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}


		
		
		
	}

