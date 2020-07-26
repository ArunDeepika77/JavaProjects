INSERT INTO product_details (id,customer_name,customer_id,validity_date,product_name,product_id,unit_of_measure,unit_price,sub_total) VALUES
  (1,'Kathir', '661','20/09/2020','HUL','12','1','10','20'),
  (2,'Muthu', '662','20/09/2020','ITC','17','1','10','20'),
  (3,'Deepan', '663','20/09/2020','Reliance','16','1','10','20'),
  (4,'Deepika', '664','20/09/2020','BPL','15','1','10','20'),
  (5,'Sub', '665','20/09/2020','IJK','14','1','10','20'),
  (6,'Sam', '666','20/09/2020','JK','13','1','10','20');
INSERT INTO quotation_details (id, customer_id, validity_date, sales_person, total,status) VALUES
 (1,'661','20/09/2020','A','1','sold'),
  (2,'662','20/09/2020','B','1','quoting'),
  (3,'663','20/09/2020','C','1','sold'),
  (4, '664','20/09/2020','A','1','quoting'),
  (5,'665','20/09/2020','B','1','sold'),
  (6,'666','20/09/2020','c','1','quoting');