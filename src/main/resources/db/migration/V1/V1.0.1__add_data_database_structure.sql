INSERT INTO customer ("name", email, mobile_number, pwd, "role")
VALUES ('Happy', 'happy@example.com', '0202', '$2a$10$BHQoWw9sXn/9kh3uX98yDu2lNMqVzcE.dyhVsflFLQGpJZS7OetfK', 'ADMIN');

INSERT INTO account (customer_id, account_id, account_type, branch_address)
VALUES (1, 1865764534, 'Savings', '123 Main Street, New York');

INSERT INTO account_transaction (account_id, customer_id, transaction_date, transaction_summary,
                                 transaction_type, transaction_amt,
                                 closing_balance)
VALUES (1865764534, 1, CURRENT_DATE - 7, 'Coffee Shop', 'Withdrawal', 30, 34500);

INSERT INTO account_transaction (account_id, customer_id, transaction_date, transaction_summary,
                                 transaction_type, transaction_amt,
                                 closing_balance)
VALUES (1865764534, 1, CURRENT_DATE - 6, 'Uber', 'Withdrawal', 100, 34400);

INSERT INTO account_transaction (account_id, customer_id, transaction_date, transaction_summary,
                                 transaction_type, transaction_amt,
                                 closing_balance)
VALUES (1865764534, 1, CURRENT_DATE - 5, 'Self Deposit', 'Deposit', 500, 34900);

INSERT INTO account_transaction (account_id, customer_id, transaction_date, transaction_summary,
                                 transaction_type, transaction_amt,
                                 closing_balance)
VALUES (1865764534, 1, CURRENT_DATE - 4, 'Ebay', 'Withdrawal', 600, 34300);

INSERT INTO account_transaction (account_id, customer_id, transaction_date, transaction_summary,
                                 transaction_type, transaction_amt,
                                 closing_balance)
VALUES (1865764534, 1, CURRENT_DATE - 2, 'OnlineTransfer', 'Deposit', 700, 35000);

INSERT INTO account_transaction (account_id, customer_id, transaction_date, transaction_summary,
                                 transaction_type, transaction_amt,
                                 closing_balance)
VALUES (1865764534, 1, CURRENT_DATE - 1, 'Amazon.com', 'Withdrawal', 100, 34900);

INSERT INTO loan (customer_id, start_dt, loan_type, total_loan, amount_paid, outstanding_amount)
VALUES (1, '2020-10-13', 'Home', 200000, 50000, 150000);

INSERT INTO loan (customer_id, start_dt, loan_type, total_loan, amount_paid, outstanding_amount)
VALUES (1, '2020-06-06', 'Vehicle', 40000, 10000, 30000);

INSERT INTO loan (customer_id, start_dt, loan_type, total_loan, amount_paid, outstanding_amount)
VALUES (1, '2018-02-14', 'Home', 50000, 10000, 40000);

INSERT INTO loan (customer_id, start_dt, loan_type, total_loan, amount_paid, outstanding_amount)
VALUES (1, '2018-02-14', 'Personal', 10000, 3500, 6500);

INSERT INTO card (card_number, customer_id, card_type, total_limit, amount_used, available_amount)
VALUES ('4565XXXX4656', 1, 'Credit', 10000, 500, 9500);

INSERT INTO card (card_number, customer_id, card_type, total_limit, amount_used, available_amount)
VALUES ('3455XXXX8673', 1, 'Credit', 7500, 600, 6900);

INSERT INTO card (card_number, customer_id, card_type, total_limit, amount_used, available_amount)
VALUES ('2359XXXX9346', 1, 'Credit', 20000, 4000, 16000);

INSERT INTO notice_detail (notice_summary, notice_details, notic_beg_dt, notic_end_dt)
VALUES ('Home Loan Interest rates reduced',
        'Home loan interest rates are reduced as per the goverment guidelines. The updated rates will be effective immediately',
        CURRENT_DATE - INTERVAL '30 DAY', CURRENT_DATE + INTERVAL '30 DAY');

INSERT INTO notice_detail (notice_summary, notice_details, notic_beg_dt, notic_end_dt)
VALUES ('Net Banking Offers',
        'Customers who will opt for Internet banking while opening a saving account will get a $50 amazon voucher',
        CURRENT_DATE - INTERVAL '30 DAY', CURRENT_DATE + INTERVAL '30 DAY');

INSERT INTO notice_detail (notice_summary, notice_details, notic_beg_dt, notic_end_dt)
VALUES ('Mobile App Downtime',
        'The mobile application of the EazyBank will be down from 2AM-5AM on 12/05/2020 due to maintenance activities',
        CURRENT_DATE - INTERVAL '30 DAY', CURRENT_DATE + INTERVAL '30 DAY');


INSERT INTO notice_detail (notice_summary, notice_details, notic_beg_dt, notic_end_dt)
VALUES ('Launch of Millennia card',
        'Millennia Credit card are launched for the premium customers of EazyBank. With these card, you will get 5% cashback for each purchase',
        CURRENT_DATE - INTERVAL '30 DAY', CURRENT_DATE + INTERVAL '30 DAY');

INSERT INTO notice_detail (notice_summary, notice_details, notic_beg_dt, notic_end_dt)
VALUES ('E Auction notice',
        'There will be a e-auction on 12/08/2020 on the Bank website for all the stubborn arrears.Interested parties can participate in the e-auction',
        CURRENT_DATE - INTERVAL '30 DAY', CURRENT_DATE + INTERVAL '30 DAY');

INSERT INTO notice_detail (notice_summary, notice_details, notic_beg_dt, notic_end_dt)
VALUES ('COVID-19 Insurance',
        'EazyBank launched an insurance policy which will cover COVID-19 expenses. Please reach out to the branch for more details',
        CURRENT_DATE - INTERVAL '30 DAY', CURRENT_DATE + INTERVAL '30 DAY');
