# Java Exam

My exam for Java OOP:

Q1 [25 Marks]

a) Write a crypto exchange simulation. Develop a console application that has Traders (N=5...10) and one Crypto Exchange. Each trader and the exchange are separate threads, and all threads   are working concurrently. When the crypto exchange (main thread) starts, it spawns the traders and when it finishes, it safely terminates traders’ threads.
The exchange (main thread) manages a ledger (thread-safe queue) shared between traders, where traders publish their offers. A ledger only records the amount(Integer) of satoshi a trader wants to sell. After each trade, each trader sleeps from 1000 to 3000 milliseconds randomly and then they wake up and generate a random value between 1 and 1000 (the amount of satoshi they want to sell) and publish the value to the exchange. This is continually repeated until the exchange closes. The exchange closes when the user presses any key. Once the key is pressed the exchange then sends the terminating signal to each trader thread and waits for all trader’s threads to safely terminate before closing the application.

You are expected to take advantage of the java.util.concurrent package, namely ArrayBlockingQueue and ThreadLocalRandom libraries.

[15 marks]

b) Write a crypto Exchange logging service. Add new functionality to your program by logging every transaction made on an Exchange. The exchange should log every transaction made by all traders to a (market.log) file with each transaction on a separate line. Each transaction should be timestamped as well. This should be achieved by adding functionality to an Exchange class, Modification to a Trader class should not be necessary.
Example of market.log file:
1617693102 - 62 satoshi
1617693345 - 10 satoshi
1617694511 - 1 satoshi
1617694512 - 99 satoshi

[5 marks]

c) Write a Traders logging service. Add new functionality to your program by logging every transaction each trader has made. Each transaction should be logged in a single file (trades.log - one file for all the traders) with each transaction on a separate line. All active traders should append every transaction to a trades.log file. Every transaction must have a timestamp, unique trader ID (thread ID or custom name) and the value a trader class randomly generated (amount of satoshi). This should be achieved by modifying a Trader class, not an Exchange class.
Example of traders.log file:
1617693102 - Trader 1 - 62 satoshi
1617693345 - Trader 2 - 10 satoshi
1617694511 - Trader 4 - 1 satoshi
1617694512 - Trader 2 - 99 satoshi

[5 marks]

Q2 [25 marks]

(a) The Little Cake Factory (LCF) hired your company to design their order system. As a cake shop, they have different cakes options. Create an inheritance hierarchy to represent the different cakes. The base class should be Cake and then include two different icings, PrintedCake and HandmadeCake options that derive from Cake. The customer can still order a cake without icing options, in this case, the Cake class should be called to create a concrete instance of Cake and icing can be set to None. The base class Cake should only include:

  ○ Private data members of type String for: ■ cakeName ■ Flavour ■ shape (Circle, Rectangle, Heart) ■ colour of the Cake ■ icing
  ○ data members that:
    ■ Store the diameter (in inches)
    ■ Cost per inch.
    
The constructor should initialise these members with parameter corresponding to all data members. Ensure that diameter is a positive integer with a minimum value of 6 and cost is a floating-point number greater than 0. The public interface should contain a method calculatePrice() that determines the cost by multiplying the diameter by cost per inch. PrintedCake and HandmadeCake should inherit directly from Cake. They should each contain one additional data member to represent additional fees. The PrintedCake has an additional flat fee, and the HandmadeCake has an additional fee per letter to be written on the cake. Each class will have to implement their versions of calculatePrice(). Write the code for each class.
[8 Marks]

(b) Create an Order class and a Customer class. An order object is made up of one or more cakes. The Order class should also include:

  ○ order number String or integer
  ○ order date: Date
  ○ delivery date: Date
  ○ Customer number: Integer
  
A customer can have zero or more orders. Customer number (integer to be customer ID), name, delivery address, along with phone number and email address for orders can be derived from the customer object.

[8 Marks]

(c) As a part of the application, the kitchen, packing, and delivery departments in LCF need information about every day’s orders. Create a Java program that maintains a collection of all orders and provides functionality to output the following for a specific day:

  ○ All the cakes that the kitchen needs to prepare. Loop through orders and display order number and the cakes in each order.
  ○ A list of orders for the packing team: Loop through the array of objects and for each object invoke get() methods to obtain cake information, then print to the console all cakes info in        one order. Also, print the cost for each order, call the calculatePrice() method from Cake. Output sample:
  
      Order Number: 12135
      Order Cost: €60
      Cakes:
      Cake Name Flavour Diameter Shape Colour Icing
      Red velvet Vanilla 8 Heart Red Printed
      Oreo Cake Chocolate 10 Circle White None ○ A delivery list for the delivery team: The delivery list must show Customer info and their orders numbers. Output sample:
      Customer Name: John Smith Phone Number: 0851234567
      Address: 10 Smith Street, Dublin
      Email address: john@smith.com
      Orders: 12135, 12140
      
Note: The output can output more data if you feel needed.

Q4 [25 marks]

Within Java, a button component can be used for triggering different events. There are different types of buttons that can be utilised.
Flemings Electrical Ltd based in the Republic of Ireland trade with the UK. On 1st January 2021, because of Brexit, extra details are required on their VAT return to handle Postponed VAT Accounting (PVA). They have hired you to develop an application which will allow a user to type in this extra information. The information that is required is as follows:

  ● Year – integer value – greater than 2020 and less than 2050.
  ● Month – integer value – range 1 to 12.
  ● VAT Reference – string – minimum characters 10.
  ● Goods amount – float – should allow negative values.

Because Flemings Electrical do not trade with the UK every month, not all months require this information to be entered.

You are required to:

a) Write a class to represent the PVA information required. You should ensure that the setter methods for your properties performs the required validation.

[5 marks]

b) The requirements for this PVA input screen are as follows:

    i. The user is allowed enter in the Year / Month.
    ii. The user can then choose whether this Year/Month combination requires VAT information to be input. Utilise one of the GUI components to enable / disable the VAT Reference / Goods     fields entry. These fields should only be enabled if the user has indicated that they have data for this month. Note – if there is no data to be entered, then only the year and month are saved to your class.
    iii. A Cancel button is required on this input screen. If the user clicks this button, they should be asked to confirm they want to exit. Exit should close the PVA input screen.
    iv. A Save button is required which allows you to save the data that the user entered. This button should only be enabled when the user has entered in valid data. When the Save button is clicked – the user should be asked to confirm that the data is correct. The data should be saved to a text file – no specific format required.
    
You are required to:
1. Provide a flowchart or pseudocode to represent the requirements.
2. Write a GUI to satisfy these requirements.
3. Provide a test plan indicating several tests which will test the requirements.
4. Provide an execution plan (screen shots) based on your test plan proving that the requirements have been fulfilled.
5. 
[20 marks]
