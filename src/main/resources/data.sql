
-- CHANNELS

INSERT INTO channels (id, name, handle) VALUES
  (1, 'Clint''s Reptiles', 'clintsreptiles'),
  (2, 'Tasting History with Max Miller', 'tastinghistory'),
  (3, 'Alec Steele', 'alecsteele'),
  (4, 'MythBusters', 'mythbusters'),
  (5, 'Gamers Nexus', 'gamersnexus'),
  (6, 'Broughy1322', 'broughy1322');


-- SERIES / PLAYLISTS

INSERT INTO series (id, title) VALUES
  -- Clint
  (1, 'Reptile Care Basics'),
  (2, 'Field Herping Adventures'),
  -- Max
  (3, 'Historical Dishes'),
  (4, 'Historical Drinks'),
  -- Alec
  (5, 'Forged Projects'),
  (6, 'Shop Techniques'),
  -- MythBusters
  (7, 'Myth Testing'),
  (8, 'Behind the Experiments'),
  -- Gamers Nexus
  (9, 'PC Hardware Deep Dives'),
  (10, 'Cooling & Thermals'),
  -- Broughy
  (11, 'GTA Racing – Cars'),
  (12, 'GTA Racing – Bikes');


-- GENRES

INSERT INTO genres (id, name) VALUES
  (1, 'Animals'),
  (2, 'Nature'),
  (3, 'History'),
  (4, 'Cooking'),
  (5, 'Metalwork'),
  (6, 'Science'),
  (7, 'Technology'),
  (8, 'Gaming'),
  (9, 'Motorsport'),
  (10, 'Experiment');


-- VIDEOS – Clint's Reptiles (1001–1010)

INSERT INTO videos (id, version, title, description, release_date, stream_url,
                    visibility, channel_id, series_id, position_in_series) VALUES
(1001, 0,
 'Top 5 Beginner-Friendly Reptiles',
 'An introduction to a few reptiles great for beginners.',
 '2025-01-10',
 'https://cdn.edufy.local/reptiles/top5.mp4',
 'PUBLIC',
 1, 1, 1
),
(1002, 0,
 'How to Set Up a Bioactive Terrarium',
 'Step by step how to build a bioactive terrarium.',
 '2025-01-17',
 'https://cdn.edufy.local/reptiles/bioactive_setup.mp4',
 'PUBLIC',
 1, 1, 2
),
(1003, 0,
 'Handling Nervous Snakes Safely',
 'Tips for secure handling of anxious snakes.',
 '2025-01-24',
 'https://cdn.edufy.local/reptiles/nervous_snakes.mp4',
 'PUBLIC',
 1, 1, 3
),
(1004, 0,
 'Best Feeder Insects for Lizards',
 'Review of different forage insects and nutritional value.',
 '2025-01-31',
 'https://cdn.edufy.local/reptiles/feeder_insects.mp4',
 'PUBLIC',
 1, 1, 4
),
(1005, 0,
 'Shedding Problems and How to Fix Them',
 'Common causes of poor shedding and solutions.',
 '2025-02-07',
 'https://cdn.edufy.local/reptiles/shedding_help.mp4',
 'PUBLIC',
 1, 1, 5
),
(1006, 0,
 'Field Herping in Utah Desert',
 'Clint explores reptiles in a desert environment.',
 '2025-02-14',
 'https://cdn.edufy.local/reptiles/herping_utah.mp4',
 'PUBLIC',
 1, 2, 1
),
(1007, 0,
 'Night Herping in Tropical Forest',
 'Nighttime hunting for frogs and geckos.',
 '2025-02-21',
 'https://cdn.edufy.local/reptiles/night_forest.mp4',
 'PUBLIC',
 1, 2, 2
),
(1008, 0,
 'Searching for Turtles in Spring',
 'Spring excursion with a focus on turtles.',
 '2025-02-28',
 'https://cdn.edufy.local/reptiles/spring_turtles.mp4',
 'PUBLIC',
 1, 2, 3
),
(1009, 0,
 'Field Trip: Snakes of the Grasslands',
 'Documentation of snakes in grassland.',
 '2025-03-07',
 'https://cdn.edufy.local/reptiles/grassland_snakes.mp4',
 'PUBLIC',
 1, 2, 4
),
(1010, 0,
 'Herping with Kids – Safety Tips',
 'How to safely herp with family.',
 '2025-03-14',
 'https://cdn.edufy.local/reptiles/herping_with_kids.mp4',
 'PUBLIC',
 1, 2, 5
);

-- VIDEOS – Tasting History (1011–1020)

INSERT INTO videos (id, version, title, description, release_date, stream_url,
                    visibility, channel_id, series_id, position_in_series) VALUES
(1011, 0,
 'Cooking Ancient Roman Honey Cakes',
 'Max makes a historical dessert from the Roman Empire.',
 '2025-01-12',
 'https://cdn.edufy.local/food/roman_cakes.mp4',
 'PUBLIC',
 2, 3, 1
),
(1012, 0,
 'Medieval Bread from Scratch',
 'Medieval bread with sourdough and wood oven.',
 '2025-01-19',
 'https://cdn.edufy.local/food/medieval_bread.mp4',
 'PUBLIC',
 2, 3, 2
),
(1013, 0,
 'Tudor Meat Pie Recreation',
 'A hearty meat pie inspired by the Tudor era.',
 '2025-01-26',
 'https://cdn.edufy.local/food/tudor_meat_pie.mp4',
 'PUBLIC',
 2, 3, 3
),
(1014, 0,
 '18th Century Street Food',
 'A look at historical food that was sold on the streets.',
 '2025-02-02',
 'https://cdn.edufy.local/food/street_food_18th.mp4',
 'PUBLIC',
 2, 3, 4
),
(1015, 0,
 'Viking Stew with Modern Ingredients',
 'An interpretation of a Viking Age stew.',
 '2025-02-09',
 'https://cdn.edufy.local/food/viking_stew.mp4',
 'PUBLIC',
 2, 3, 5
),
(1016, 0,
 'Recreating Ancient Greek Wine',
 'Historical drink reconstructed with modern methods.',
 '2025-02-16',
 'https://cdn.edufy.local/drink/greek_wine.mp4',
 'PUBLIC',
 2, 4, 1
),
(1017, 0,
 'Medieval Spiced Ale',
 'Spiced ale based on medieval recipes.',
 '2025-02-23',
 'https://cdn.edufy.local/drink/spiced_ale.mp4',
 'PUBLIC',
 2, 4, 2
),
(1018, 0,
 'Renaissance Fruit Punch',
 'Festive drink from Renaissance banquets.',
 '2025-03-02',
 'https://cdn.edufy.local/drink/renaissance_punch.mp4',
 'PUBLIC',
 2, 4, 3
),
(1019, 0,
 'Historic Hot Chocolate Variations',
 'Different historical versions of hot chocolate.',
 '2025-03-09',
 'https://cdn.edufy.local/drink/historic_hot_choc.mp4',
 'PUBLIC',
 2, 4, 4
),
(1020, 0,
 'Roman-Style Refreshing Summer Drink',
 'Summery drink inspired by ancient Rome.',
 '2025-03-16',
 'https://cdn.edufy.local/drink/roman_summer_drink.mp4',
 'PUBLIC',
 2, 4, 5
);

-- VIDEOS – Alec Steele (1021–1030)

INSERT INTO videos (id, version, title, description, release_date, stream_url,
                    visibility, channel_id, series_id, position_in_series) VALUES
(1021, 0,
 'Forging a High-Carbon Utility Knife',
 'Knife from steel bar to finished product.',
 '2025-01-13',
 'https://cdn.edufy.local/forge/utility_knife.mp4',
 'PUBLIC',
 3, 5, 1
),
(1022, 0,
 'Building a Pattern-Welded Blade',
 'Project with patterned steel.',
 '2025-01-20',
 'https://cdn.edufy.local/forge/pattern_welded_blade.mp4',
 'PUBLIC',
 3, 5, 2
),
(1023, 0,
 'Forged Chef''s Knife for Daily Use',
 'Practical kitchen knife, full blacksmithing project.',
 '2025-01-27',
 'https://cdn.edufy.local/forge/chefs_knife.mp4',
 'PUBLIC',
 3, 5, 3
),
(1024, 0,
 'Making a Viking-Style Axe',
 'Decorative but functional axe.',
 '2025-02-03',
 'https://cdn.edufy.local/forge/viking_axe.mp4',
 'PUBLIC',
 3, 5, 4
),
(1025, 0,
 'Forging a Small Hammer for the Shop',
 'Build your own sledgehammer-like tool.',
 '2025-02-10',
 'https://cdn.edufy.local/forge/shop_hammer.mp4',
 'PUBLIC',
 3, 5, 5
),
(1026, 0,
 'Heat Treating Basics Explained',
 'Hardening and tempering for different types of steel.',
 '2025-02-17',
 'https://cdn.edufy.local/forge/heat_treat_basics.mp4',
 'PUBLIC',
 3, 6, 1
),
(1027, 0,
 'Grinding and Polishing Techniques',
 'Smooth grinding and mirror polishing.',
 '2025-02-24',
 'https://cdn.edufy.local/forge/grinding_polishing.mp4',
 'PUBLIC',
 3, 6, 2
),
(1028, 0,
 'Forge Maintenance and Safety',
 'Routines to keep the forge safe and efficient.',
 '2025-03-03',
 'https://cdn.edufy.local/forge/maintenance_safety.mp4',
 'PUBLIC',
 3, 6, 3
),
(1029, 0,
 'Intro to Damascus Pattern Design',
 'How to plan the pattern in Damascus steel.',
 '2025-03-10',
 'https://cdn.edufy.local/forge/damascus_intro.mp4',
 'PUBLIC',
 3, 6, 4
),
(1030, 0,
 'Tool Making: Tongs for Beginners',
 'Forges simple pliers for beginners.',
 '2025-03-17',
 'https://cdn.edufy.local/forge/beginner_tongs.mp4',
 'PUBLIC',
 3, 6, 5
);

-- VIDEOS – MythBusters (1031–1040)

INSERT INTO videos (id, version, title, description, release_date, stream_url,
                    visibility, channel_id, series_id, position_in_series) VALUES
(1031, 0,
 'Can a Car Really Explode from Heat?',
 'Testing a popular Hollywood myth.',
 '2025-01-14',
 'https://cdn.edufy.local/myths/car_heat.mp4',
 'PUBLIC',
 4, 7, 1
),
(1032, 0,
 'Is Duct Tape Strong Enough to Lift a Person?',
 'Experiment with tape and weights.',
 '2025-01-21',
 'https://cdn.edufy.local/myths/duct_tape_lift.mp4',
 'PUBLIC',
 4, 7, 2
),
(1033, 0,
 'Can You Dodge a Paintball?',
 'Reaction time and physics in focus.',
 '2025-01-28',
 'https://cdn.edufy.local/myths/dodge_paintball.mp4',
 'PUBLIC',
 4, 7, 3
),
(1034, 0,
 'Will a Coin Dropped from a Skyscraper Kill?',
 'Classic myth of falling coins.',
 '2025-02-04',
 'https://cdn.edufy.local/myths/coin_skyscraper.mp4',
 'PUBLIC',
 4, 7, 4
),
(1035, 0,
 'Is Running or Walking Better in the Rain?',
 'Test of how to get the least wet.',
 '2025-02-11',
 'https://cdn.edufy.local/myths/rain_walk_run.mp4',
 'PUBLIC',
 4, 7, 5
),
(1036, 0,
 'Inside an Industrial Fire Suppression System',
 'The technology behind large fire extinguishing systems.',
 '2025-02-18',
 'https://cdn.edufy.local/myths/fire_suppression.mp4',
 'PUBLIC',
 4, 8, 1
),
(1037, 0,
 'Slow-Motion Bullet Impact Lab',
 'High-speed camera tests.',
 '2025-02-25',
 'https://cdn.edufy.local/myths/bullet_lab.mp4',
 'PUBLIC',
 4, 8, 2
),
(1038, 0,
 'Crash Test Dummy Instrumentation',
 'Review of sensors and data from crash tests.',
 '2025-03-04',
 'https://cdn.edufy.local/myths/crash_test_lab.mp4',
 'PUBLIC',
 4, 8, 3
),
(1039, 0,
 'Building a Miniature Myth Setup',
 'Scale models for safe experiments.',
 '2025-03-11',
 'https://cdn.edufy.local/myths/miniature_setups.mp4',
 'PUBLIC',
 4, 8, 4
),
(1040, 0,
 'Data Logging for Myth Experiments',
 'How measurement data is collected and analyzed.',
 '2025-03-18',
 'https://cdn.edufy.local/myths/data_logging.mp4',
 'PUBLIC',
 4, 8, 5
);

-- VIDEOS – Gamers Nexus (1041–1050)

INSERT INTO videos (id, version, title, description, release_date, stream_url,
                    visibility, channel_id, series_id, position_in_series) VALUES
(1041, 0,
 'RTX 5090 Launch Review',
 'Review of performance, price and positioning.',
 '2025-01-15',
 'https://cdn.edufy.local/gn/rtx5090_review.mp4',
 'PUBLIC',
 5, 9, 1
),
(1042, 0,
 'Next-Gen CPU Roundup',
 'Comparison of modern CPU families.',
 '2025-01-22',
 'https://cdn.edufy.local/gn/cpu_roundup.mp4',
 'PUBLIC',
 5, 9, 2
),
(1043, 0,
 'Budget Gaming PC Build Guide',
 'Building an affordable computer for 1080p gaming.',
 '2025-01-29',
 'https://cdn.edufy.local/gn/budget_build.mp4',
 'PUBLIC',
 5, 9, 3
),
(1044, 0,
 'High-End Workstation for Content Creators',
 'Computer built for rendering and video editing.',
 '2025-02-05',
 'https://cdn.edufy.local/gn/workstation_build.mp4',
 'PUBLIC',
 5, 9, 4
),
(1045, 0,
 'SSD Endurance Testing Explained',
 'Analysis of write wear on modern SSDs.',
 '2025-02-12',
 'https://cdn.edufy.local/gn/ssd_endurance.mp4',
 'PUBLIC',
 5, 9, 5
),
(1046, 0,
 'AIO Cooler Test – 2025 Roundup',
 'Comparison of AIO water coolers.',
 '2025-02-19',
 'https://cdn.edufy.local/gn/aio_roundup.mp4',
 'PUBLIC',
 5, 10, 1
),
(1047, 0,
 'Air Coolers vs Liquid Coolers',
 'Advantages and disadvantages of different cooling methods.',
 '2025-02-26',
 'https://cdn.edufy.local/gn/air_vs_liquid.mp4',
 'PUBLIC',
 5, 10, 2
),
(1048, 0,
 'Case Airflow Optimization',
 'How to place fans for best cooling.',
 '2025-03-05',
 'https://cdn.edufy.local/gn/case_airflow.mp4',
 'PUBLIC',
 5, 10, 3
),
(1049, 0,
 'Thermal Pad vs Thermal Paste Testing',
 'Different materials for heat transfer.',
 '2025-03-12',
 'https://cdn.edufy.local/gn/thermal_materials.mp4',
 'PUBLIC',
 5, 10, 4
),
(1050, 0,
 'GPU Cooling Mod Experiments',
 'Modification of coolers and flows.',
 '2025-03-19',
 'https://cdn.edufy.local/gn/gpu_cooling_mods.mp4',
 'PUBLIC',
 5, 10, 5
);

-- VIDEOS – Broughy1322 (1051–1060)

INSERT INTO videos (id, version, title, description, release_date, stream_url,
                    visibility, channel_id, series_id, position_in_series) VALUES
(1051, 0,
 'GTA V Lap Times – Sports Class',
 'Timing of racing cars in the sports class.',
 '2025-01-16',
 'https://cdn.edufy.local/broughy/sports_class_laps.mp4',
 'PUBLIC',
 6, 11, 1
),
(1052, 0,
 'GTA V Lap Times – Super Class',
 'Timing of cars in the super class.',
 '2025-01-23',
 'https://cdn.edufy.local/broughy/super_class_laps.mp4',
 'PUBLIC',
 6, 11, 2
),
(1053, 0,
 'Top Speed Testing on Long Straight',
 'Comparison of top speed of different car types.',
 '2025-01-30',
 'https://cdn.edufy.local/broughy/top_speed_tests.mp4',
 'PUBLIC',
 6, 11, 3
),
(1054, 0,
 'Handling Test – Tight City Circuit',
 'How different cars behave in technical city layout.',
 '2025-02-06',
 'https://cdn.edufy.local/broughy/city_handling.mp4',
 'PUBLIC',
 6, 11, 4
),
(1055, 0,
 'Endurance Race – 1-Hour GTA Event',
 'Bigger competition with a focus on consistency.',
 '2025-02-13',
 'https://cdn.edufy.local/broughy/endurance_race.mp4',
 'PUBLIC',
 6, 11, 5
),
(1056, 0,
 'GTA V Bikes – Lap Time Testing',
 'Comparison of motorcycles on track.',
 '2025-02-20',
 'https://cdn.edufy.local/broughy/bike_lap_times.mp4',
 'PUBLIC',
 6, 12, 1
),
(1057, 0,
 'GTA V Bikes – Top Speed Ranking',
 'Top list of fastest motorcycles.',
 '2025-02-27',
 'https://cdn.edufy.local/broughy/bike_top_speed.mp4',
 'PUBLIC',
 6, 12, 2
),
(1058, 0,
 'Real Track Day – Lightweight Car',
 'Data analysis from a real track run.',
 '2025-03-06',
 'https://cdn.edufy.local/broughy/trackday_lightweight.mp4',
 'PUBLIC',
 6, 12, 3
),
(1059, 0,
 'Real Track Day – Sportsbike',
 'Lap times and telemetry from motorcycles on the track.',
 '2025-03-13',
 'https://cdn.edufy.local/broughy/trackday_sportsbike.mp4',
 'PUBLIC',
 6, 12, 4
),
(1060, 0,
 'Comparing GTA Cars to Real Lap Data',
 'How well the game matches real-world times.',
 '2025-03-20',
 'https://cdn.edufy.local/broughy/gta_vs_real.mp4',
 'PUBLIC',
 6, 12, 5
);

-- VIDEO_GENRES

-- Clint's Reptiles (1001–1010)
INSERT INTO video_genres (video_id, genre_id) VALUES
(1001, 1), (1001, 2),
(1002, 1),
(1003, 1),
(1004, 1),
(1005, 1),
(1006, 1), (1006, 2),
(1007, 1), (1007, 2),
(1008, 1), (1008, 2),
(1009, 1), (1009, 2),
(1010, 1);

-- Tasting History (1011–1020)
INSERT INTO video_genres (video_id, genre_id) VALUES
(1011, 3), (1011, 4),
(1012, 3), (1012, 4),
(1013, 3), (1013, 4),
(1014, 3), (1014, 4),
(1015, 3), (1015, 4),
(1016, 3), (1016, 4),
(1017, 3), (1017, 4),
(1018, 3), (1018, 4),
(1019, 3), (1019, 4),
(1020, 3), (1020, 4);

-- Alec Steele (1021–1030)
INSERT INTO video_genres (video_id, genre_id) VALUES
(1021, 5),
(1022, 5),
(1023, 5),
(1024, 5),
(1025, 5),
(1026, 5), (1026, 6),
(1027, 5),
(1028, 5),
(1029, 5),
(1030, 5);

-- MythBusters (1031–1040)
INSERT INTO video_genres (video_id, genre_id) VALUES
(1031, 6), (1031, 10),
(1032, 6), (1032, 10),
(1033, 6), (1033, 10),
(1034, 6), (1034, 10),
(1035, 6), (1035, 10),
(1036, 6),
(1037, 6),
(1038, 6),
(1039, 6),
(1040, 6);

-- Gamers Nexus (1041–1050)
INSERT INTO video_genres (video_id, genre_id) VALUES
(1041, 7),
(1042, 7),
(1043, 7),
(1044, 7),
(1045, 7),
(1046, 7), (1046, 6),
(1047, 7), (1047, 6),
(1048, 7), (1048, 6),
(1049, 7),
(1050, 7);

-- Broughy1322 (1051–1060)
INSERT INTO video_genres (video_id, genre_id) VALUES
(1051, 8), (1051, 9),
(1052, 8), (1052, 9),
(1053, 8), (1053, 9),
(1054, 8), (1054, 9),
(1055, 8), (1055, 9),
(1056, 8),
(1057, 8),
(1058, 9),
(1059, 9),
(1060, 8), (1060, 9);
