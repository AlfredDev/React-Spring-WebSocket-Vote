-- Insertar candidatos con IDs manuales
INSERT INTO candidates (id, name, party_name)
VALUES (1, 'Alice Johnson', 'Green Party'),
       (2, 'Bob Smith', 'Blue Party'),
       (3, 'Charlie Brown', 'Red Party'),
       (4, 'David Wilson', 'Yellow Party'),
       (5, 'Eva Martinez', 'Purple Party'),
       (6, 'Frank Moore', 'Orange Party'),
       (7, 'Grace Lee', 'Pink Party'),
       (8, 'Hank Taylor', 'Grey Party'),
       (9, 'Ivy Harris', 'White Party'),
       (10, 'Jack Young', 'Black Party'),
       (11, 'Karen Anderson', 'Blue Party'),
       (12, 'Larry Thomas', 'Red Party'),
       (13, 'Mona Clark', 'Green Party'),
       (14, 'Nancy Lewis', 'Yellow Party'),
       (15, 'Oscar Walker', 'Purple Party'),
       (16, 'Paul Harris', 'Orange Party'),
       (17, 'Quinn Robinson', 'Pink Party'),
       (18, 'Rita Adams', 'Grey Party'),
       (19, 'Steve King', 'White Party'),
       (20, 'Tina Wright', 'Black Party'),
       (21, 'Ursula Scott', 'Blue Party'),
       (22, 'Victor Green', 'Red Party'),
       (23, 'Wendy Baker', 'Green Party'),
       (24, 'Xander Evans', 'Yellow Party'),
       (25, 'Yvonne Collins', 'Purple Party'),
       (26, 'Zachary Nelson', 'Orange Party'),
       (27, 'Alan Carter', 'Pink Party'),
       (28, 'Betty Mitchell', 'Grey Party'),
       (29, 'Carl Lopez', 'White Party'),
       (30, 'Diana Rodriguez', 'Black Party'),
       (31, 'Edward Lewis', 'Blue Party'),
       (32, 'Fiona Lee', 'Red Party'),
       (33, 'George Wilson', 'Green Party'),
       (34, 'Helen Allen', 'Yellow Party'),
       (35, 'Ian Turner', 'Purple Party'),
       (36, 'Judy Davis', 'Orange Party'),
       (37, 'Kevin Martin', 'Pink Party'),
       (38, 'Lydia Clark', 'Grey Party'),
       (39, 'Mike Harris', 'White Party'),
       (40, 'Nancy Lewis', 'Black Party'),
       (41, 'Oliver Walker', 'Blue Party'),
       (42, 'Paula Scott', 'Red Party'),
       (43, 'Quincy Hill', 'Green Party'),
       (44, 'Rachael Young', 'Yellow Party'),
       (45, 'Sam Turner', 'Purple Party'),
       (46, 'Tracy Moore', 'Orange Party'),
       (47, 'Ulysses King', 'Pink Party'),
       (48, 'Vera Thompson', 'Grey Party'),
       (49, 'Will Nelson', 'White Party'),
       (50, 'Xena Clark', 'Black Party'),
       (51, 'Yosef Davis', 'Blue Party');

-- Insertar encuestas con IDs manuales
INSERT INTO polls (id, name, start_date, end_date)
VALUES (1, '2024 Presidential Election', '2024-01-01', '2024-12-31'),
       (2, 'Local Council Elections', '2024-06-01', '2024-06-30'),
       (3, 'Regional Assembly Vote', '2024-03-01', '2024-03-15'),
       (4, 'Senate Confirmation', '2024-04-01', '2024-04-30'),
       (5, 'General Referendum', '2024-05-01', '2024-05-31'),
       (6, 'Primary Election', '2024-02-01', '2024-02-28'),
       (7, 'City Mayoral Race', '2024-07-01', '2024-07-31'),
       (8, 'School Board Vote', '2024-08-01', '2024-08-31'),
       (9, 'Governor Election', '2024-09-01', '2024-09-30'),
       (10, 'Statewide Referendum', '2024-10-01', '2024-10-31'),
       (11, 'Municipal Elections', '2024-11-01', '2024-11-30'),
       (12, 'Presidential Primary', '2024-12-01', '2024-12-31'),
       (13, 'National Assembly Election', '2024-06-01', '2024-06-30'),
       (14, 'District Council Vote', '2024-07-01', '2024-07-31'),
       (15, 'County Elections', '2024-08-01', '2024-08-31'),
       (16, 'Judicial Confirmation', '2024-09-01', '2024-09-30'),
       (17, 'Regional Referendum', '2024-10-01', '2024-10-31'),
       (18, 'Local Primary Election', '2024-11-01', '2024-11-30'),
       (19, 'State Senate Race', '2024-12-01', '2024-12-31'),
       (20, 'City Council Vote', '2024-01-01', '2024-01-31'),
       (21, 'Regional Council Elections', '2024-02-01', '2024-02-29'),
       (22, 'Local Referendum', '2024-03-01', '2024-03-31'),
       (23, 'Statewide Primary', '2024-04-01', '2024-04-30'),
       (24, 'National Referendum', '2024-05-01', '2024-05-31'),
       (25, 'County Board Elections', '2024-06-01', '2024-06-30'),
       (26, 'Municipal Council Vote', '2024-07-01', '2024-07-31'),
       (27, 'Judicial Elections', '2024-08-01', '2024-08-31'),
       (28, 'State Assembly Vote', '2024-09-01', '2024-09-30'),
       (29, 'Citywide Referendum', '2024-10-01', '2024-10-31'),
       (30, 'Local Council Race', '2024-11-01', '2024-11-30'),
       (31, 'Regional Elections', '2024-12-01', '2024-12-31'),
       (32, 'Statewide Council Vote', '2024-01-01', '2024-01-31'),
       (33, 'Municipal Referendum', '2024-02-01', '2024-02-29'),
       (34, 'County Elections', '2024-03-01', '2024-03-31'),
       (35, 'Statewide Vote', '2024-04-01', '2024-04-30'),
       (36, 'City Referendum', '2024-05-01', '2024-05-31'),
       (37, 'Local Elections', '2024-06-01', '2024-06-30'),
       (38, 'Regional Vote', '2024-07-01', '2024-07-31'),
       (39, 'State Council Race', '2024-08-01', '2024-08-31'),
       (40, 'National Elections', '2024-09-01', '2024-09-30'),
       (41, 'Municipal Vote', '2024-10-01', '2024-10-31'),
       (42, 'Local Board Elections', '2024-11-01', '2024-11-30'),
       (43, 'State Referendum', '2024-12-01', '2024-12-31');

-- Insertar votos con IDs manuales
INSERT INTO votes (id, user_id, poll_id, candidate_id, timestamp)
VALUES (1, 1, 1, 1, '2024-01-02T10:00:00'),
       (2, 1, 1, 2, '2024-01-02T10:10:00'),
       (3, 1, 2, 3, '2024-06-02T11:00:00'),
       (4, 1, 2, 4, '2024-06-02T11:15:00'),
       (5, 1, 3, 5, '2024-03-02T12:00:00'),
       (6, 1, 3, 6, '2024-03-02T12:20:00'),
       (7, 1, 4, 7, '2024-04-02T13:00:00'),
       (8, 1, 4, 8, '2024-04-02T13:30:00'),
       (9, 1, 5, 9, '2024-05-02T14:00:00'),
       (10, 1, 5, 10, '2024-05-02T14:45:00'),
       (11, 1, 6, 11, '2024-02-02T15:00:00'),
       (12, 1, 6, 12, '2024-02-02T15:30:00'),
       (13, 1, 7, 13, '2024-07-02T16:00:00'),
       (14, 1, 7, 14, '2024-07-02T16:20:00'),
       (15, 1, 8, 15, '2024-08-02T17:00:00'),
       (16, 1, 8, 16, '2024-08-02T17:30:00'),
       (17, 1, 9, 17, '2024-09-02T18:00:00'),
       (18, 1, 9, 18, '2024-09-02T18:15:00'),
       (19, 1, 10, 19, '2024-10-02T19:00:00'),
       (20, 1, 10, 20, '2024-10-02T19:30:00'),
       (21, 1, 11, 21, '2024-11-02T20:00:00'),
       (22, 1, 11, 22, '2024-11-02T20:15:00'),
       (23, 1, 12, 23, '2024-12-02T21:00:00'),
       (24, 1, 12, 24, '2024-12-02T21:30:00'),
       (25, 1, 13, 25, '2024-01-03T10:00:00'),
       (26, 1, 13, 26, '2024-01-03T10:30:00'),
       (27, 1, 14, 27, '2024-06-03T11:00:00'),
       (28, 1, 14, 28, '2024-06-03T11:45:00'),
       (29, 1, 15, 29, '2024-03-03T12:00:00'),
       (30, 1, 15, 30, '2024-03-03T12:20:00'),
       (31, 1, 16, 31, '2024-04-03T13:00:00'),
       (32, 1, 16, 32, '2024-04-03T13:45:00'),
       (33, 1, 17, 33, '2024-05-03T14:00:00'),
       (34, 1, 17, 34, '2024-05-03T14:30:00'),
       (35, 1, 18, 35, '2024-07-03T15:00:00'),
       (36, 1, 18, 36, '2024-07-03T15:30:00'),
       (37, 1, 19, 37, '2024-08-03T16:00:00'),
       (38, 1, 19, 38, '2024-08-03T16:30:00'),
       (39, 1, 20, 39, '2024-09-03T17:00:00'),
       (40, 1, 20, 40, '2024-09-03T17:30:00'),
       (41, 1, 21, 41, '2024-10-03T18:00:00'),
       (42, 1, 21, 42, '2024-10-03T18:30:00'),
       (43, 1, 22, 43, '2024-11-03T19:00:00'),
       (44, 1, 22, 44, '2024-11-03T19:30:00'),
       (45, 1, 23, 45, '2024-12-03T20:00:00'),
       (46, 1, 23, 46, '2024-12-03T20:30:00'),
       (47, 1, 24, 47, '2024-01-04T10:00:00'),
       (48, 1, 24, 48, '2024-01-04T10:30:00'),
       (49, 1, 25, 49, '2024-06-04T11:00:00'),
       (50, 1, 25, 50, '2024-06-04T11:30:00');

