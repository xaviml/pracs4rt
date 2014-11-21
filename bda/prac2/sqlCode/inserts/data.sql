INSERT INTO Data 
	SELECT
		cast(extract(year FROM datum)as text) AS Year,
		null AS desc_any,
		(cast(extract(month FROM datum)as text) ||'-'|| cast(extract(year FROM datum)as text)) AS Month,
		null AS desc_mes,
		(cast(extract(day FROM datum)as text) ||'-'||cast(extract(month FROM datum) as text)|| '-' || cast(extract(year FROM datum) as text)) AS Day,
		null AS desc_dia
	
	FROM (
		-- There are 3 leap years in this range, so calculate 365 * 10 + 3 records
		SELECT '2000-01-01'::DATE + sequence.day AS datum
		FROM generate_series(0,3652) AS sequence(day)
		GROUP BY sequence.day
	     ) DQ
	ORDER BY 1

