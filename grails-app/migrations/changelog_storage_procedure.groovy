databaseChangeLog = {
	changeSet(author: "eduardo", id: "DISTANCIA_GEOGRAFICA") {
		change {
			sql.execute("""
CREATE OR REPLACE FUNCTION distancia_geografica(latitudeParameter NUMERIC,longitudeParameter NUMERIC) RETURNS NUMERIC AS \$\$
BEGIN
    RETURN (
        6371 * acos(
            cos(radians(latitudeParameter)) 
            * cos(radians(latitude)) 
            * cos(radians(longitude) - radians(longitudeParameter)) 
            + sin(radians(latitudeParameter)) 
            * sin(radians(latitude))
        )
    );
END;
\$\$ LANGUAGE plpgsql;
			""")
		}
	}
	changeSet(author: "eduardo", id: "DISTANCIA_GEOGRAFICA_MILHA") {
		change {
			sql.execute("""
CREATE OR REPLACE FUNCTION distancia_geografica_milha(latitudeParameter NUMERIC,longitudeParameter NUMERIC) RETURNS NUMERIC AS \$\$
BEGIN
    RETURN (
        3959 * acos(
            cos(radians(latitudeParameter)) 
            * cos(radians(latitude)) 
            * cos(radians(longitude) - radians(longitudeParameter)) 
            + sin(radians(latitudeParameter)) 
            * sin(radians(latitude))
        )
    );
END;
\$\$ LANGUAGE plpgsql;
			""")
		}
	}
}
