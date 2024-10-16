databaseChangeLog = {
	changeSet(author: "eduardo", id: "DISTANCIA_GEOGRAFICA") {
		change {
			sql.execute("""
CREATE OR REPLACE FUNCTION distancia_geografica(latitudeParameter NUMERIC,longitudeParameter NUMERIC,latitude NUMERIC,longitude NUMERIC) RETURNS NUMERIC AS \$\$
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
CREATE OR REPLACE FUNCTION distancia_geografica(double precision, double precision, double precision, double precision) RETURNS numeric AS
\$BODY\$
    BEGIN
        RETURN distancia_geografica(\$1::numeric, \$2::numeric, \$3::numeric, \$4::numeric);
    END;
\$BODY\$
\$\$ LANGUAGE plpgsql;
CREATE OR REPLACE FUNCTION distancia_geografica(numeric, numeric, real, real) RETURNS numeric AS
\$BODY\$
    BEGIN
        RETURN distancia_geografica(\$1::numeric, \$2::numeric, \$3::numeric, \$4::numeric);
    END;
\$BODY\$
\$\$ LANGUAGE plpgsql;
CREATE OR REPLACE FUNCTION distancia_geografica(numeric, numeric, double precision, double precision) RETURNS numeric AS
\$BODY\$
    BEGIN
        RETURN distancia_geografica(\$1::numeric, \$2::numeric, \$3::numeric, \$4::numeric);
    END;
\$BODY\$
\$\$ LANGUAGE plpgsql;
CREATE OR REPLACE FUNCTION distancia_geografica(numeric, numeric, real, double precision) RETURNS numeric AS
\$BODY\$
    BEGIN
        RETURN distancia_geografica(\$1::numeric, \$2::numeric, \$3::numeric, \$4::numeric);
    END;
\$BODY\$
\$\$ LANGUAGE plpgsql;
CREATE OR REPLACE FUNCTION distancia_geografica(numeric, numeric, double precision, real) RETURNS numeric AS
\$BODY\$
    BEGIN
        RETURN distancia_geografica(\$1::numeric, \$2::numeric, \$3::numeric, \$4::numeric);
    END;
\$BODY\$
\$\$ LANGUAGE plpgsql;
			""")
		}
	}
	changeSet(author: "eduardo", id: "DISTANCIA_GEOGRAFICA_MILHA") {
		change {
			sql.execute("""
CREATE OR REPLACE FUNCTION distancia_geografica(latitudeParameter NUMERIC,longitudeParameter NUMERIC,latitude NUMERIC,longitude NUMERIC) RETURNS NUMERIC AS \$\$
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
