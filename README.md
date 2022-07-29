Coverage: 66.0%
Jira : https://conorwhite.atlassian.net/jira/software/projects/IMCW/boards/5

## Inventory Management System!

# Hello! Welcome to the Inventory Management System! 
This system is designed to keep track of Customers, Items and Orders. You are able to Create, Read, Update and Delete Customers, Items and Orders in this nifty little application. 

## Getting Started

To get started simply fork this repo and clone it down to your local machine. You will then need to go into db.properties and set the db.user and db.password to the mySql username and password that is set on your local machine. 
After this you will need to 

### Prerequisites

You will need the following : 

Eclipse

JDK 8 

MAVEN

MySql

### Obtraining Prerequisites

##Eclipse 
To run this program the easiest way is through the IDE Eclipse. You can find a link here https://www.eclipse.org/downloads/

Click on Get Eclipse IDE 2022-06 

![image](https://user-images.githubusercontent.com/49778033/181751334-c50fb8aa-8a7b-413c-a1e4-f636fcb6e85a.png)

Then click on the Download button. This will download the eclipse installer on your local machine. Open the .exe file and follow the steps on screen.

##JDK 
- You will need a version of java JDK downloaded in order to run the program. I have used JDK 8 for this project so it is not reccomended to run newer versions as some 
  features may not work. 
  You can find a version here : https://www.oracle.com/tr/java/technologies/javase/javase8-archive-downloads.html
  You will need to download the version for the operating system on your local machine
  ![image](https://user-images.githubusercontent.com/49778033/181752621-1c4fc053-0b11-4c22-95cf-a5212c9c8eab.png)
  ![image](https://user-images.githubusercontent.com/49778033/181752652-6f6793ec-5a16-4d4c-8c1a-b465253d8f53.png)
  
##Maven
To download Maven on your computer follow this link https://maven.apache.org/install.html 

You will then need to follow the steps on the website to install.

##MySql 
Follow this link to download MySql on your local machine. https://dev.mysql.com/downloads/mysql/

Make sure to select the correct operating system. 

![image](https://user-images.githubusercontent.com/49778033/181753004-61a36926-6d79-4e01-8161-a683024e1421.png)

then click download.

![image](https://user-images.githubusercontent.com/49778033/181753125-62b20387-46f1-4774-8d74-075b49d2cc32.png)

### Running the program

#getting the project

Now that you have the prerequisites installed is is time to run the program. 
To get the program files, go to : https://github.com/conor667/IMSConorWhite and click the blue code button then select Download as ZIP:

![image](https://user-images.githubusercontent.com/49778033/181753788-f77fc602-1867-4026-a7ea-29e4d33e88e9.png)

Once this has been downloaded, unzip the folder and make sure you remember where you have saved it. 


Once you have done this open up the Eclipse IDE.

Go to 'File' on the top left and select open projects from system: 

Then select directory in the top right of this window : 

![image](https://user-images.githubusercontent.com/49778033/181754241-c296608c-59d5-46ff-a25c-0df2d3a49d28.png)

You will then need to locate the folder and click select folder on the bottom right of the new window

![image](https://user-images.githubusercontent.com/49778033/181754296-f4f205bf-6eea-4e2f-9766-d221ed82d9ff.png)

Then click Finish on the bottom right of the import window. 


![image](https://user-images.githubusercontent.com/49778033/181754029-3c2ce0e5-454d-4e8f-8072-25fb040fa7a5.png)


find where the unzipped folder has been saved and select this folder.

It should now appear in the Project Explorer

![image](https://user-images.githubusercontent.com/49778033/181755291-c1cd14a5-1ec2-4252-bb0f-e60a0c50cd47.png)

Click the arrow to the left of the folder and it should open the folders inside

from here you can right click src/main/java, go down to run as and select java application

![image](https://user-images.githubusercontent.com/49778033/181755568-ef8665af-b558-4725-8731-d27d596e608d.png)

The console should open and display your options :

![image](https://user-images.githubusercontent.com/49778033/181756296-b5d9200c-81bc-4edd-a17b-5c27f1a5d75f.png)

You are now able to use the system. 

Selecting any option will take you to sub commands where you are able to manipulate the data

For instance, you can go into customer -> create and enter your information to add a customer to the database. 
To create an order you will need to first create a customer and an item. Once this is done you can go into Order and type create.
This will ask you for a customer ID and will make an order for this customer.
You can then select Update which will allow you to add items to the order.
Selecting Delete will allow you to either remove an item from the order, or remove an order completely.

## Running the tests

To run the tests you can either run all of the tests at once or certain tests. 

For all tests simply right click on src/java/test and go to run as, then select JunitTest

![image](https://user-images.githubusercontent.com/49778033/181757170-86f64ed7-aedb-4e39-b09d-2beab0b16357.png)

this will run the tests and display the information of if they passed, failed and why they failed.

to run a specific test you will need to open the folders containing that test, for example src/test/java/com.qa.ims/controllers/ItemControllerTest.

You will then need to rightclick the test and then run it in the same was as above. 

### Unit Tests 

A unit test is a way to test a method or function seperately without worrying about the code inside. This simply looks to see if it is working or not by having 
certain pass parameters.
For this I used Junit.

For example : 

![image](https://user-images.githubusercontent.com/49778033/181757617-d7ab696d-bf8e-4357-b708-78533ea706c2.png)

This test is passing in a new Order and then checking that when the create method is called the order is made. 

### Integration Tests 
An integreation test is a type of testing where software modules are tested as a group. This is able to test multiple methods are combined. 
For this test I used Mockito as it can mock user inputs which will be able to test a variety of methods.

![image](https://user-images.githubusercontent.com/49778033/181758138-9584b396-5de1-4ef9-aab9-6d77e0268d4f.png)

The test above is testing multiple methods that work together to achieve the outcome for the update Method. 


## Deployment

To deploy this applictaion you will need to build it using Maven. 

This can be done simply by typing in the terminal, mvn clean package. This will run the tests and if everything passes it will create a new .jar file in the 
target folder which can be found inside the IMSConorWhite folder. 

if you do not currently have a terminal open, rightlcick on IMSConorWhite, go to show in local terminal and click terminal. 

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## Versioning

I have used GitHub for version control


![image](https://user-images.githubusercontent.com/49778033/181776347-e693111a-cb3f-4258-b7e8-554d1513496c.png)


## Authors

* **Chris Perrins** - *Initial work* - [christophperrins](https://github.com/christophperrins)
* **Conor White** - https://github.com/conor667/

## License

This project is licensed under the MIT license - see the [LICENSE.md](LICENSE.md) file for details 

*For help in [Choosing a license](https://choosealicense.com/)*

## Acknowledgments

* Hat tip to anyone whose code was used
* Inspiration
* etc
