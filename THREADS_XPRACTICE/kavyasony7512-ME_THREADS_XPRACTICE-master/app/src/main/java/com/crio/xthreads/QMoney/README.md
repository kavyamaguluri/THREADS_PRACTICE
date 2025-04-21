# Problem Statement
## Title: Multi-threaded Stock Return Calculator - QMoney

### Objective: Implement a multi-threaded program to calculate stock returns for a portfolio of trades using historical stock data.

You have a portfolio of trades that includes the purchase dates and stock symbols. The goal is to calculate both the total return and the annualized return for each stock in the portfolio as of a fixed end date. Since processing each stock's data involves fetching historical price information, this task can be time-consuming. To optimize performance, you need to implement a solution that processes multiple trades concurrently using multithreading.

### Output
```bash
Symbol: AAPL | Total Return: 75.26% | Annualized Return: 81.44%
Symbol: MSFT | Total Return: 53.93% | Annualized Return: 58.09%
Symbol: GOOGL | Total Return: 31.28% | Annualized Return: 33.50%
```


# Implementation

1. `QMoneyCalculator Class:` Class:
   - Responsibilities:
      - Calculate the total and annualized returns for a given stock symbol.
      - Fetch historical stock data using a specified stock data service (e.g., TIINGO).
   - Methods:
      - calculateReturns(String symbol, LocalDate startDate, LocalDate endDate): 
        - Returns a ReturnSummary object containing the stock symbol, total return, and annualized return.
   - Internal Logic:
      - Fetch historical stock data between the purchase date (`startDate`) and the end date (`endDate`).
      - Compute the total return based on the opening price on the purchase date and the closing price on the end date.
      - Compute the annualized return based on the total return and the holding period in years.

3. Implement `main` method in `App` Class:
   - Responsibilities:
      - Manage the execution of the stock return calculation for multiple trades concurrently.
      - Use an ExecutorService to manage a pool of threads for parallel processing.
   - Workflow:
      - Initialize a QMoneyCalculator with a stock data service type.
      - Load trades from a JSON file.
      - Create a fixed thread pool using ExecutorService to process trades concurrently.
      - Submit tasks to calculate returns for each trade, and collect the results using Future.
      - Handle any exceptions that occur during task execution and ensure the ExecutorService shuts down gracefully.