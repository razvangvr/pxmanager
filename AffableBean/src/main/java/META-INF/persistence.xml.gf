<?xml version="1.0" encoding="UTF-8"?>
<persistence version="2.1" xmlns="http://xmlns.jcp.org/xml/ns/persistence" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/persistence http://xmlns.jcp.org/xml/ns/persistence/persistence_2_1.xsd">
  <persistence-unit name="AffableBeanPU" transaction-type="JTA">
    <jta-data-source>jdbc/myRazTestDEL</jta-data-source>
    <class>entity.Category</class>
    <class>entity.Customer</class>
    <class>entity.CustomerOrder</class>
    <class>entity.OrderProduct</class>
    <class>entity.Product</class>
    <exclude-unlisted-classes>false</exclude-unlisted-classes>
    <properties/>
  </persistence-unit>
</persistence>