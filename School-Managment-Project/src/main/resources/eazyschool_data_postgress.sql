
CREATE TABLE IF NOT EXISTS  contact_msg  (
   contact_id BIGSERIAL  PRIMARY KEY,
   name  varchar(100) NOT NULL,
   mobile_num  varchar(10) NOT NULL,
   email  varchar(100) NOT NULL,
   subject  varchar(100) NOT NULL,
   message  varchar(500) NOT NULL,
   status  varchar(10) NOT NULL,
   created_at  TIMESTAMP NOT NULL,
   created_by  varchar(50) NOT NULL,
   updated_at  TIMESTAMP DEFAULT NULL,
   updated_by  varchar(50) DEFAULT NULL
);

CREATE TABLE IF NOT EXISTS  holidays  (
   day  varchar(20) NOT NULL,
   reason  varchar(100) NOT NULL,
   type  varchar(20) NOT NULL,
   created_at  TIMESTAMP NOT NULL,
   created_by  varchar(50) NOT NULL,
   updated_at  TIMESTAMP DEFAULT NULL,
   updated_by  varchar(50) DEFAULT NULL
);

CREATE TABLE IF NOT EXISTS  roles  (
   role_id  BIGSERIAL,
   role_name  varchar(50) NOT NULL,
   created_at  TIMESTAMP NOT NULL,
   created_by  varchar(50) NOT NULL,
   updated_at  TIMESTAMP DEFAULT NULL,
   updated_by  varchar(50) DEFAULT NULL,
   PRIMARY KEY ( role_id )
);

CREATE TABLE IF NOT EXISTS  address  (
   address_id  BIGSERIAL,
   address1  varchar(200) NOT NULL,
   address2  varchar(200) DEFAULT NULL,
   city  varchar(50) NOT NULL,
   state  varchar(50) NOT NULL,
   zip_code  int NOT NULL,
   created_at  TIMESTAMP NOT NULL,
   created_by  varchar(50) NOT NULL,
   updated_at  TIMESTAMP DEFAULT NULL,
   updated_by  varchar(50) DEFAULT NULL,
   PRIMARY KEY ( address_id )
);

CREATE TABLE IF NOT EXISTS  person  (
   person_id  BIGSERIAL,
   name  varchar(100) NOT NULL,
   email  varchar(50) NOT NULL,
   mobile_number  varchar(20) NOT NULL,
   pwd  varchar(200) NOT NULL,
   role_id  int NOT NULL,
   address_id  int NULL,
   created_at  TIMESTAMP NOT NULL,
   created_by  varchar(50) NOT NULL,
   updated_at  TIMESTAMP DEFAULT NULL,
   updated_by  varchar(50) DEFAULT NULL,
   PRIMARY KEY ( person_id ),
   FOREIGN KEY (role_id) REFERENCES roles(role_id),
   FOREIGN KEY (address_id) REFERENCES address(address_id)
);
CREATE TABLE IF NOT EXISTS  class  (
   class_id  BIGSERIAL,
   name  varchar(100) NOT NULL,
   created_at  TIMESTAMP NOT NULL,
   created_by  varchar(50) NOT NULL,
   updated_at  TIMESTAMP DEFAULT NULL,
   updated_by  varchar(50) DEFAULT NULL,
   PRIMARY KEY ( class_id )
);



ALTER TABLE person ADD COLUMN address_id int;

ALTER TABLE person  ADD CONSTRAINT  FK_CLASS_CLASS_ID  FOREIGN KEY ( class_id )
REFERENCES  class ( class_id );

ALTER TABLE orders
    ADD CONSTRAINT fk_orders_customers FOREIGN KEY (customer_id) REFERENCES customers (id);

CREATE TABLE IF NOT EXISTS  courses  (
   course_id BIGSERIAL,
   name  varchar(100) NOT NULL,
   fees  varchar(10) NOT NULL,
   created_at  TIMESTAMP NOT NULL,
   created_by  varchar(50) NOT NULL,
   updated_at  TIMESTAMP DEFAULT NULL,
   updated_by  varchar(50) DEFAULT NULL,
   PRIMARY KEY ( course_id )
);

CREATE TABLE IF NOT EXISTS  person_courses  (
   person_id  int NOT NULL,
   course_id  int NOT NULL,
  FOREIGN KEY (person_id) REFERENCES person(person_id),
  FOREIGN KEY (course_id) REFERENCES courses(course_id),
   PRIMARY KEY ( person_id , course_id )
);


INSERT INTO  holidays  ( day , reason , type , created_at ,  created_by )
 VALUES (' Jan 1 ','New Year''s Day','FESTIVAL',now(),'DBA');

INSERT INTO  holidays  ( day , reason , type , created_at ,  created_by )
 VALUES (' Oct 31 ','Halloween','FESTIVAL',now(),'DBA');

INSERT INTO  holidays  ( day , reason , type , created_at ,  created_by )
 VALUES (' Nov 24 ','Thanksgiving Day','FESTIVAL',now(),'DBA');

INSERT INTO  holidays  ( day , reason , type , created_at ,  created_by )
 VALUES (' Dec 25 ','Christmas','FESTIVAL', now(),'DBA');

INSERT INTO  holidays  ( day , reason , type , created_at ,  created_by )
 VALUES (' Jan 17 ','Martin Luther King Jr. Day','FEDERAL', now(),'DBA');

INSERT INTO  holidays  ( day , reason , type , created_at ,  created_by )
 VALUES (' July 4 ','Independence Day','FEDERAL', now(),'DBA');

INSERT INTO  holidays  ( day , reason , type , created_at ,  created_by )
 VALUES (' Sep 5 ','Labor Day','FEDERAL', now(),'DBA');

INSERT INTO  holidays  ( day , reason , type , created_at ,  created_by )
  VALUES (' Nov 11 ','Veterans Day','FEDERAL', now(),'DBA');

INSERT INTO  roles  ( role_name , created_at ,  created_by )
  VALUES ('ADMIN', now(),'DBA');

INSERT INTO  roles  ( role_name , created_at ,  created_by )
  VALUES ('STUDENT', now(),'DBA');

DELETE FROM person where email='admin@eazyschool.com';

INSERT INTO  person  ( name , email , mobile_number , pwd , role_id , created_at ,  created_by )
  VALUES ('Admin','admin@eazyschool.com','3443434343','$2a$12$b3IjViwK7V7U3wKhyPIcZezxhFxYHROIKY1Jjw0763YA76sujPtNO', 1 ,now(),'DBA');


