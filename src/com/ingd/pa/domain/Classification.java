package com.ingd.pa.domain;


public enum Classification {
    //Takes over 50% of their transactions in the month after midday (count of transactions)
    Afternoon_Person,
    // Spends over 80% of their deposits every month ($ value of deposits)
    Big_Spender,
    //Makes one or more withdrawals over $1000 in the month
    Big_Ticket_Spender,
    //Spends over 75% of any deposit within 7 days of making it
    Fast_Spender,
    //Makes over 50% of their transactions in the month before midday (count of transactions)
    Morning_Person,
    //Spends less than 25% of their deposits every month ($ value of deposits)
    Potential_Saver,
    //If a person is identified as both a Big Spender and a Fast Spender then they should be classified as a Potential Loan customer instead.
    Potential_Loan
}
