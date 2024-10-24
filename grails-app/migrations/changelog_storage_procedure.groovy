databaseChangeLog = {
	changeSet(author: "eduardo", id: "DISTANCIA_GEOGRAFICA") {
		grailsChange {
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
CREATE OR REPLACE FUNCTION distancia_geografica(double precision, double precision, double precision, double precision) RETURNS numeric AS \$\$
BEGIN
    RETURN distancia_geografica(\$1::numeric, \$2::numeric, \$3::numeric, \$4::numeric);
END;
\$\$ LANGUAGE plpgsql;
CREATE OR REPLACE FUNCTION distancia_geografica(numeric, numeric, real, real) RETURNS numeric AS \$\$
BEGIN
    RETURN distancia_geografica(\$1::numeric, \$2::numeric, \$3::numeric, \$4::numeric);
END;
\$\$ LANGUAGE plpgsql;
CREATE OR REPLACE FUNCTION distancia_geografica(numeric, numeric, double precision, double precision) RETURNS numeric AS \$\$
BEGIN
    RETURN distancia_geografica(\$1::numeric, \$2::numeric, \$3::numeric, \$4::numeric);
END;
\$\$ LANGUAGE plpgsql;
CREATE OR REPLACE FUNCTION distancia_geografica(numeric, numeric, real, double precision) RETURNS numeric AS \$\$
BEGIN
    RETURN distancia_geografica(\$1::numeric, \$2::numeric, \$3::numeric, \$4::numeric);
END;
\$\$ LANGUAGE plpgsql;
CREATE OR REPLACE FUNCTION distancia_geografica(numeric, numeric, double precision, real) RETURNS numeric AS \$\$
BEGIN
    RETURN distancia_geografica(\$1::numeric, \$2::numeric, \$3::numeric, \$4::numeric);
END;
\$\$ LANGUAGE plpgsql;
CREATE OR REPLACE FUNCTION distancia_geografica(latitudeParameter double precision, longitudeParameter double precision, latitude real, longitude real) RETURNS numeric AS \$\$
BEGIN
    RETURN distancia_geografica(latitudeParameter::numeric, longitudeParameter::numeric, latitude::numeric, longitude::numeric);
END;
\$\$ LANGUAGE plpgsql;

""")
			}
		}
	}
}
