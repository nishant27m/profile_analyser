

### Problem Definition

The marketing department is responsible for profiling customers for e-mail targeting based on their monthly spending habits.
They have decided to classify customers based on the following rules:

```
Classification	        Rule

Afternoon Person	    Makes over 50% of their transactions in the month after midday (count of transactions)
Big Spender	            Spends over 80% of their deposits every month ($ value of deposits)
Big Ticket Spender	    Makes one or more withdrawals over $1000 in the month
Fast Spender	        Spends over 75% of any deposit within 7 days of making it
Morning Person	        Makes over 50% of their transactions in the month before midday (count of transactions)
Potential Saver	        Spends less than 25% of their deposits every month ($ value of deposits)

```

```
•	Periods are delimited by the first day of each month (e.g. July 2016 is defined as 1st July 2016 to 31st July 2016 inclusive)
•	If a person is identified as both a Big Spender and a Fast Spender then they should be classified as a Potential Loan customer instead.
        The marketing department wants a user interface where they can enter the month (e.g. July 2016) and CustomerId and be presented with:
•	The Classification
•	The list of transactions processed, with the Current Balance as of today
```

### Getting Started
```

git clone https://github.com/nishant27m/profile_analyser.git
or
download from  https://github.com/nishant27m/profile_analyser.git

cd profile_analyser

javac -sourcepath src -d out src\\com\\ingd\\pa\\*.java

java -cp out com.ingd.pa.Main

```

### Note :

````
1. Please use options given in the bracket as limited set of data is prepared for this example.
2. you must have java installed on your machine.
````