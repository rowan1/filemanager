--Query
select users.user_id, users.user_name, training_details.training_id, training_details.training_date, COUNT(users.user_id) as count from users inner join training_details on users.user_id = training_details.user_id group by(users.user_id,training_details.training_id, training_details.training_date) HAVING COUNT(users.user_id) > 1 order by (training_details.training_date) desc;

--// user_id |  user_name  | training_id | training_date | count
--//       ---------+-------------+-------------+---------------+-------
--//       4 | Lisa Romero |           2 | 2015-08-04    |     2
--//       4 | Lisa Romero |           3 | 2015-08-03    |     2
--//       1 | John Doe    |           1 | 2015-08-02    |     3
--//       3 | Alice Jones |           2 | 2015-08-02    |     2
