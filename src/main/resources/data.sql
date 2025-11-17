
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
  (1, 'Djur'),
  (2, 'Natur'),
  (3, 'Historia'),
  (4, 'Matlagning'),
  (5, 'Metallarbete'),
  (6, 'Vetenskap'),
  (7, 'Teknik'),
  (8, 'Gaming'),
  (9, 'Motorsport'),
  (10, 'Experiment');


-- VIDEOS – Clint's Reptiles (1001–1010)

INSERT INTO videos (id, version, title, description, release_date, stream_url,
                    visibility, channel_id, series_id, position_in_series) VALUES
(1001, 0,
 'Top 5 Beginner-Friendly Reptiles',
 'En genomgång av reptiler som passar nybörjare.',
 '2025-01-10',
 'https://cdn.edufy.local/reptiles/top5.mp4',
 'PUBLIC',
 1, 1, 1
),
(1002, 0,
 'How to Set Up a Bioactive Terrarium',
 'Steg för steg hur man bygger ett bioaktivt terrarium.',
 '2025-01-17',
 'https://cdn.edufy.local/reptiles/bioactive_setup.mp4',
 'PUBLIC',
 1, 1, 2
),
(1003, 0,
 'Handling Nervous Snakes Safely',
 'Tips för säker hantering av stressade ormar.',
 '2025-01-24',
 'https://cdn.edufy.local/reptiles/nervous_snakes.mp4',
 'PUBLIC',
 1, 1, 3
),
(1004, 0,
 'Best Feeder Insects for Lizards',
 'Genomgång av olika foderinsekter och näringsvärde.',
 '2025-01-31',
 'https://cdn.edufy.local/reptiles/feeder_insects.mp4',
 'PUBLIC',
 1, 1, 4
),
(1005, 0,
 'Shedding Problems and How to Fix Them',
 'Vanliga orsaker till dålig ömsning och lösningar.',
 '2025-02-07',
 'https://cdn.edufy.local/reptiles/shedding_help.mp4',
 'PUBLIC',
 1, 1, 5
),
(1006, 0,
 'Field Herping in Utah Desert',
 'Clint utforskar reptiler i ökenmiljö.',
 '2025-02-14',
 'https://cdn.edufy.local/reptiles/herping_utah.mp4',
 'PUBLIC',
 1, 2, 1
),
(1007, 0,
 'Night Herping in Tropical Forest',
 'Nattlig jakt på grodor och geckos.',
 '2025-02-21',
 'https://cdn.edufy.local/reptiles/night_forest.mp4',
 'PUBLIC',
 1, 2, 2
),
(1008, 0,
 'Searching for Turtles in Spring',
 'Vårutflykt med fokus på vattensköldpaddor.',
 '2025-02-28',
 'https://cdn.edufy.local/reptiles/spring_turtles.mp4',
 'PUBLIC',
 1, 2, 3
),
(1009, 0,
 'Field Trip: Snakes of the Grasslands',
 'Dokumentation av ormar i gräsmark.',
 '2025-03-07',
 'https://cdn.edufy.local/reptiles/grassland_snakes.mp4',
 'PUBLIC',
 1, 2, 4
),
(1010, 0,
 'Herping with Kids – Safety Tips',
 'Hur man herpar säkert med familjen.',
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
 'Max lagar en historisk dessert från romarriket.',
 '2025-01-12',
 'https://cdn.edufy.local/food/roman_cakes.mp4',
 'PUBLIC',
 2, 3, 1
),
(1012, 0,
 'Medieval Bread from Scratch',
 'Medeltida bröd med surdeg och vedugn.',
 '2025-01-19',
 'https://cdn.edufy.local/food/medieval_bread.mp4',
 'PUBLIC',
 2, 3, 2
),
(1013, 0,
 'Tudor Meat Pie Recreation',
 'En kraftig köttpaj inspirerad av Tudor-tiden.',
 '2025-01-26',
 'https://cdn.edufy.local/food/tudor_meat_pie.mp4',
 'PUBLIC',
 2, 3, 3
),
(1014, 0,
 '18th Century Street Food',
 'En titt på historisk mat som såldes på gatorna.',
 '2025-02-02',
 'https://cdn.edufy.local/food/street_food_18th.mp4',
 'PUBLIC',
 2, 3, 4
),
(1015, 0,
 'Viking Stew with Modern Ingredients',
 'En tolkning av vikingatida gryta.',
 '2025-02-09',
 'https://cdn.edufy.local/food/viking_stew.mp4',
 'PUBLIC',
 2, 3, 5
),
(1016, 0,
 'Recreating Ancient Greek Wine',
 'Historisk dryck rekonstruerad med moderna metoder.',
 '2025-02-16',
 'https://cdn.edufy.local/drink/greek_wine.mp4',
 'PUBLIC',
 2, 4, 1
),
(1017, 0,
 'Medieval Spiced Ale',
 'Kryddad ale utifrån medeltida recept.',
 '2025-02-23',
 'https://cdn.edufy.local/drink/spiced_ale.mp4',
 'PUBLIC',
 2, 4, 2
),
(1018, 0,
 'Renaissance Fruit Punch',
 'Festlig dryck från renässansens banketter.',
 '2025-03-02',
 'https://cdn.edufy.local/drink/renaissance_punch.mp4',
 'PUBLIC',
 2, 4, 3
),
(1019, 0,
 'Historic Hot Chocolate Variations',
 'Olika historiska versioner av varm choklad.',
 '2025-03-09',
 'https://cdn.edufy.local/drink/historic_hot_choc.mp4',
 'PUBLIC',
 2, 4, 4
),
(1020, 0,
 'Roman-Style Refreshing Summer Drink',
 'Somrig dryck inspirerad av antikens Rom.',
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
 'Kniv från stångstål till färdig produkt.',
 '2025-01-13',
 'https://cdn.edufy.local/forge/utility_knife.mp4',
 'PUBLIC',
 3, 5, 1
),
(1022, 0,
 'Building a Pattern-Welded Blade',
 'Projekt med mönstervällt stål.',
 '2025-01-20',
 'https://cdn.edufy.local/forge/pattern_welded_blade.mp4',
 'PUBLIC',
 3, 5, 2
),
(1023, 0,
 'Forged Chef''s Knife for Daily Use',
 'Praktisk kökskniv, fullt smidesprojekt.',
 '2025-01-27',
 'https://cdn.edufy.local/forge/chefs_knife.mp4',
 'PUBLIC',
 3, 5, 3
),
(1024, 0,
 'Making a Viking-Style Axe',
 'Dekorativ men funktionell yxa.',
 '2025-02-03',
 'https://cdn.edufy.local/forge/viking_axe.mp4',
 'PUBLIC',
 3, 5, 4
),
(1025, 0,
 'Forging a Small Hammer for the Shop',
 'Bygger ett eget släggliknande verktyg.',
 '2025-02-10',
 'https://cdn.edufy.local/forge/shop_hammer.mp4',
 'PUBLIC',
 3, 5, 5
),
(1026, 0,
 'Heat Treating Basics Explained',
 'Härdning och anlöpning för olika ståltyper.',
 '2025-02-17',
 'https://cdn.edufy.local/forge/heat_treat_basics.mp4',
 'PUBLIC',
 3, 6, 1
),
(1027, 0,
 'Grinding and Polishing Techniques',
 'Jämn slipning och spegelpolering.',
 '2025-02-24',
 'https://cdn.edufy.local/forge/grinding_polishing.mp4',
 'PUBLIC',
 3, 6, 2
),
(1028, 0,
 'Forge Maintenance and Safety',
 'Rutiner för att hålla smedjan säker och effektiv.',
 '2025-03-03',
 'https://cdn.edufy.local/forge/maintenance_safety.mp4',
 'PUBLIC',
 3, 6, 3
),
(1029, 0,
 'Intro to Damascus Pattern Design',
 'Hur man planerar mönstret i damaskusstål.',
 '2025-03-10',
 'https://cdn.edufy.local/forge/damascus_intro.mp4',
 'PUBLIC',
 3, 6, 4
),
(1030, 0,
 'Tool Making: Tongs for Beginners',
 'Smider enkla tänger för nybörjare.',
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
 'Test av en populär Hollywood-myt.',
 '2025-01-14',
 'https://cdn.edufy.local/myths/car_heat.mp4',
 'PUBLIC',
 4, 7, 1
),
(1032, 0,
 'Is Duct Tape Strong Enough to Lift a Person?',
 'Experiment med tejp och tyngder.',
 '2025-01-21',
 'https://cdn.edufy.local/myths/duct_tape_lift.mp4',
 'PUBLIC',
 4, 7, 2
),
(1033, 0,
 'Can You Dodge a Paintball?',
 'Reaktionstid och fysik i fokus.',
 '2025-01-28',
 'https://cdn.edufy.local/myths/dodge_paintball.mp4',
 'PUBLIC',
 4, 7, 3
),
(1034, 0,
 'Will a Coin Dropped from a Skyscraper Kill?',
 'Klassisk myt om fallande mynt.',
 '2025-02-04',
 'https://cdn.edufy.local/myths/coin_skyscraper.mp4',
 'PUBLIC',
 4, 7, 4
),
(1035, 0,
 'Is Running or Walking Better in the Rain?',
 'Test av hur man blir minst blöt.',
 '2025-02-11',
 'https://cdn.edufy.local/myths/rain_walk_run.mp4',
 'PUBLIC',
 4, 7, 5
),
(1036, 0,
 'Inside an Industrial Fire Suppression System',
 'Tekniken bakom stora brandsläckningssystem.',
 '2025-02-18',
 'https://cdn.edufy.local/myths/fire_suppression.mp4',
 'PUBLIC',
 4, 8, 1
),
(1037, 0,
 'Slow-Motion Bullet Impact Lab',
 'Tester med höghastighetskamera.',
 '2025-02-25',
 'https://cdn.edufy.local/myths/bullet_lab.mp4',
 'PUBLIC',
 4, 8, 2
),
(1038, 0,
 'Crash Test Dummy Instrumentation',
 'Genomgång av sensorer och data från krocktester.',
 '2025-03-04',
 'https://cdn.edufy.local/myths/crash_test_lab.mp4',
 'PUBLIC',
 4, 8, 3
),
(1039, 0,
 'Building a Miniature Myth Setup',
 'Skalmodeller för säkra experiment.',
 '2025-03-11',
 'https://cdn.edufy.local/myths/miniature_setups.mp4',
 'PUBLIC',
 4, 8, 4
),
(1040, 0,
 'Data Logging for Myth Experiments',
 'Hur mätdata samlas in och analyseras.',
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
 'Genomgång av prestanda, pris och positionering.',
 '2025-01-15',
 'https://cdn.edufy.local/gn/rtx5090_review.mp4',
 'PUBLIC',
 5, 9, 1
),
(1042, 0,
 'Next-Gen CPU Roundup',
 'Jämförelse av moderna CPU-familjer.',
 '2025-01-22',
 'https://cdn.edufy.local/gn/cpu_roundup.mp4',
 'PUBLIC',
 5, 9, 2
),
(1043, 0,
 'Budget Gaming PC Build Guide',
 'Bygger en prisvärd dator för 1080p gaming.',
 '2025-01-29',
 'https://cdn.edufy.local/gn/budget_build.mp4',
 'PUBLIC',
 5, 9, 3
),
(1044, 0,
 'High-End Workstation for Content Creators',
 'Dator byggd för rendering och videoredigering.',
 '2025-02-05',
 'https://cdn.edufy.local/gn/workstation_build.mp4',
 'PUBLIC',
 5, 9, 4
),
(1045, 0,
 'SSD Endurance Testing Explained',
 'Analys av skrivslitage på moderna SSD:er.',
 '2025-02-12',
 'https://cdn.edufy.local/gn/ssd_endurance.mp4',
 'PUBLIC',
 5, 9, 5
),
(1046, 0,
 'AIO Cooler Test – 2025 Roundup',
 'Jämförelse av slutna vattenkylare.',
 '2025-02-19',
 'https://cdn.edufy.local/gn/aio_roundup.mp4',
 'PUBLIC',
 5, 10, 1
),
(1047, 0,
 'Air Coolers vs Liquid Coolers',
 'För- och nackdelar med olika kylmetoder.',
 '2025-02-26',
 'https://cdn.edufy.local/gn/air_vs_liquid.mp4',
 'PUBLIC',
 5, 10, 2
),
(1048, 0,
 'Case Airflow Optimization',
 'Hur man placerar fläktar för bästa kylning.',
 '2025-03-05',
 'https://cdn.edufy.local/gn/case_airflow.mp4',
 'PUBLIC',
 5, 10, 3
),
(1049, 0,
 'Thermal Pad vs Thermal Paste Testing',
 'Olika material för värmeöverföring.',
 '2025-03-12',
 'https://cdn.edufy.local/gn/thermal_materials.mp4',
 'PUBLIC',
 5, 10, 4
),
(1050, 0,
 'GPU Cooling Mod Experiments',
 'Modifiering av kylare och flöden.',
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
 'Tidtagning på racingbilar i sportklassen.',
 '2025-01-16',
 'https://cdn.edufy.local/broughy/sports_class_laps.mp4',
 'PUBLIC',
 6, 11, 1
),
(1052, 0,
 'GTA V Lap Times – Super Class',
 'Tidtagning på bilar i superklassen.',
 '2025-01-23',
 'https://cdn.edufy.local/broughy/super_class_laps.mp4',
 'PUBLIC',
 6, 11, 2
),
(1053, 0,
 'Top Speed Testing on Long Straight',
 'Jämförelse av toppfart på olika biltyper.',
 '2025-01-30',
 'https://cdn.edufy.local/broughy/top_speed_tests.mp4',
 'PUBLIC',
 6, 11, 3
),
(1054, 0,
 'Handling Test – Tight City Circuit',
 'Hur olika bilar beter sig i teknisk stadslayout.',
 '2025-02-06',
 'https://cdn.edufy.local/broughy/city_handling.mp4',
 'PUBLIC',
 6, 11, 4
),
(1055, 0,
 'Endurance Race – 1-Hour GTA Event',
 'Större tävling med fokus på konsekvens.',
 '2025-02-13',
 'https://cdn.edufy.local/broughy/endurance_race.mp4',
 'PUBLIC',
 6, 11, 5
),
(1056, 0,
 'GTA V Bikes – Lap Time Testing',
 'Jämförelse av motorcyklar på bana.',
 '2025-02-20',
 'https://cdn.edufy.local/broughy/bike_lap_times.mp4',
 'PUBLIC',
 6, 12, 1
),
(1057, 0,
 'GTA V Bikes – Top Speed Ranking',
 'Topplista över snabbaste motorcyklar.',
 '2025-02-27',
 'https://cdn.edufy.local/broughy/bike_top_speed.mp4',
 'PUBLIC',
 6, 12, 2
),
(1058, 0,
 'Real Track Day – Lightweight Car',
 'Dataanalys från en verklig bankörning.',
 '2025-03-06',
 'https://cdn.edufy.local/broughy/trackday_lightweight.mp4',
 'PUBLIC',
 6, 12, 3
),
(1059, 0,
 'Real Track Day – Sportsbike',
 'Varvtider och telemetri från motorcykel på bana.',
 '2025-03-13',
 'https://cdn.edufy.local/broughy/trackday_sportsbike.mp4',
 'PUBLIC',
 6, 12, 4
),
(1060, 0,
 'Comparing GTA Cars to Real Lap Data',
 'Hur väl spelet matchar verkliga tider.',
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
