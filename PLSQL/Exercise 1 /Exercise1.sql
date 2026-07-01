-- Scenario 1
BEGIN
    FOR cust IN (SELECT CustomerID, Age FROM Customers) LOOP

        IF cust.Age > 60 THEN

            UPDATE Loans
            SET InterestRate = InterestRate - 1
            WHERE CustomerID = cust.CustomerID;

        END IF;

    END LOOP;

    COMMIT;
END;
/

-- Scenario 2
BEGIN
    FOR cust IN (SELECT CustomerID, Balance FROM Customers) LOOP

        IF cust.Balance > 10000 THEN

            UPDATE Customers
            SET IsVIP = TRUE
            WHERE CustomerID = cust.CustomerID;

        END IF;

    END LOOP;

    COMMIT;
END;
/

-- Scenario 3
BEGIN

    FOR loan IN (
        SELECT CustomerID, DueDate
        FROM Loans
        WHERE DueDate <= SYSDATE + 30
    )
    LOOP

        DBMS_OUTPUT.PUT_LINE(
            'Reminder sent to Customer ID: ' || loan.CustomerID
        );

    END LOOP;

END;
/