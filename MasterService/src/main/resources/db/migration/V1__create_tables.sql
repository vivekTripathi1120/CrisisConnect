-- V1__create_tables.sql
-- Flyway migration (H2-compatible) creating tables for disaster and masterService entities.
-- Place in: src/main/resources/db/migration
-- Notes:
--  - Sequences are created for entities using GenerationType.SEQUENCE.
--  - Citizen uses GenerationType.IDENTITY in Java, so citizen_id is an AUTO_INCREMENT column for H2.
--  - Disaster.type is stored as text (VARCHAR) and used as the primary key.
--  - Timestamps use H2 TIMESTAMP. Adjust for Postgres/MySQL when migrating.

-- -----------------------------
-- Sequences (H2)
-- -----------------------------
CREATE SEQUENCE IF NOT EXISTS seq_administrator_adminid START WITH 1;
CREATE SEQUENCE IF NOT EXISTS seq_admin_geo_mapping_mappingid START WITH 1;
CREATE SEQUENCE IF NOT EXISTS seq_citizen_medical_data_id START WITH 1;
CREATE SEQUENCE IF NOT EXISTS seq_fire_stations_firestatid START WITH 1;
CREATE SEQUENCE IF NOT EXISTS seq_geo_structure_geoid START WITH 1;
CREATE SEQUENCE IF NOT EXISTS seq_hospital_hospid START WITH 1;
CREATE SEQUENCE IF NOT EXISTS seq_otp_history_otpid START WITH 1;
CREATE SEQUENCE IF NOT EXISTS seq_police_station_polstatid START WITH 1;
CREATE SEQUENCE IF NOT EXISTS seq_rescue_camps_rescamid START WITH 1;

-- -----------------------------
-- Table: disaster
-- Maps: Disaster entity (disasterService)
-- Primary key: type (enum value)
-- -----------------------------
CREATE TABLE IF NOT EXISTS disaster (
  type VARCHAR(100) PRIMARY KEY,  -- enum name/identifier for disaster type
  level INT                       -- severity/level (upto 10 per Java comment)
);

COMMENT ON TABLE disaster IS 'Disaster entity (type as PK, level as severity)';
COMMENT ON COLUMN disaster.type IS 'Primary key: DisasterEnum as text';
COMMENT ON COLUMN disaster.level IS 'Numeric severity level (Number in Java)';

-- -----------------------------
-- Master service tables
-- -----------------------------

-- administrators
CREATE TABLE IF NOT EXISTS administrators (
  admin_id BIGINT PRIMARY KEY DEFAULT NEXT VALUE FOR seq_administrator_adminid,
  level INT,                 -- 1-> gov level country, 2 -> state, 3 -> city
  parent_level_id INT,
  verified_by VARCHAR(255),
  verified BOOLEAN,
  user_id BIGINT
);
COMMENT ON TABLE administrators IS 'Administrators table (masterService)';
COMMENT ON COLUMN administrators.admin_id IS 'Primary key (sequence)';

-- admin_geo_mapping
CREATE TABLE IF NOT EXISTS admin_geo_mapping (
  mapping_id BIGINT PRIMARY KEY DEFAULT NEXT VALUE FOR seq_admin_geo_mapping_mappingid,
  administrator_id BIGINT,
  geo_structure_id BIGINT,
  is_active BOOLEAN
);
COMMENT ON TABLE admin_geo_mapping IS 'Mapping between administrators and geo structures';

-- citizen
-- Note: Java uses GenerationType.IDENTITY for citizenId, so use AUTO_INCREMENT for H2.
CREATE TABLE IF NOT EXISTS citizen (
  citizen_id BIGINT PRIMARY KEY AUTO_INCREMENT,
  citizen_name VARCHAR(255),
  aadhar_card_number BIGINT,
  phone_number BIGINT,
  phone_verified BOOLEAN,
  emergency_contact_number BIGINT,
  emergency_con_num_verified BOOLEAN,
  permanent_address VARCHAR(1000),
  current_address VARCHAR(1000),
  family_member INT,
  zip_code BIGINT,
  city_id BIGINT,
  created_at TIMESTAMP,
  updated_at TIMESTAMP,
  created_by VARCHAR(255),
  updated_by VARCHAR(255)
);
COMMENT ON TABLE citizen IS 'Citizen master data';
COMMENT ON COLUMN citizen.citizen_id IS 'Primary key (identity/auto-increment)';

CREATE INDEX IF NOT EXISTS idx_citizen_phone_number ON citizen(phone_number);
CREATE INDEX IF NOT EXISTS idx_citizen_aadhar ON citizen(aadhar_card_number);

-- citizen_medical_data
CREATE TABLE IF NOT EXISTS citizen_medical_data (
  citizen_medical_his_id BIGINT PRIMARY KEY DEFAULT NEXT VALUE FOR seq_citizen_medical_data_id,
  blood_group VARCHAR(50),
  medical_condition VARCHAR(1000)
);
COMMENT ON TABLE citizen_medical_data IS 'Historical/medical details for citizens';

-- fire_stations
CREATE TABLE IF NOT EXISTS fire_stations (
  fire_stat_id BIGINT PRIMARY KEY DEFAULT NEXT VALUE FOR seq_fire_stations_firestatid,
  fire_stat_address VARCHAR(1000),
  fire_stat_head_counts VARCHAR(255),
  no_of_aval_vehicle BIGINT,
  verified BOOLEAN
);
COMMENT ON TABLE fire_stations IS 'Fire station reference data';

-- geo_structure
CREATE TABLE IF NOT EXISTS geo_structure (
  geo_id BIGINT PRIMARY KEY DEFAULT NEXT VALUE FOR seq_geo_structure_geoid,
  geo_level INT,
  geo_name VARCHAR(255),
  parent_geo_id BIGINT,
  created_at TIMESTAMP,
  created_by VARCHAR(255),
  updated_at TIMESTAMP,
  updated_by VARCHAR(255)
);
COMMENT ON TABLE geo_structure IS 'Geographical hierarchy (country/state/city/...)';
CREATE INDEX IF NOT EXISTS idx_geo_parent ON geo_structure(parent_geo_id);

-- hospital
CREATE TABLE IF NOT EXISTS hospital (
  hosp_id BIGINT PRIMARY KEY DEFAULT NEXT VALUE FOR seq_hospital_hospid,
  hosp_name VARCHAR(255),
  hosp_address VARCHAR(1000),
  no_of_aval_beds BIGINT,
  no_of_aval_doc BIGINT,
  verified BOOLEAN,
  no_of_ambul BIGINT
);
COMMENT ON TABLE hospital IS 'Hospital reference data';

-- otp_history
CREATE TABLE IF NOT EXISTS otp_history (
  otp_id BIGINT PRIMARY KEY DEFAULT NEXT VALUE FOR seq_otp_history_otpid,
  otp BIGINT,
  user_id BIGINT,
  user_type INT,
  phone_type INT,
  phone_number BIGINT,
  created_at TIMESTAMP,
  created_by VARCHAR(255),
  updated_at TIMESTAMP,
  updated_by VARCHAR(255)
);
COMMENT ON TABLE otp_history IS 'OTP history records for authentication/verification';
CREATE INDEX IF NOT EXISTS idx_otp_user_phone ON otp_history(user_id, phone_number);

-- police_station
CREATE TABLE IF NOT EXISTS police_station (
  pol_stat_id BIGINT PRIMARY KEY DEFAULT NEXT VALUE FOR seq_police_station_polstatid,
  pol_stat_address VARCHAR(1000),
  stat_head_counts VARCHAR(255),
  verified BOOLEAN
);
COMMENT ON TABLE police_station IS 'Police station reference data';

-- rescue_camps
CREATE TABLE IF NOT EXISTS rescue_camps (
  res_cam_id BIGINT PRIMARY KEY DEFAULT NEXT VALUE FOR seq_rescue_camps_rescamid,
  res_cam_name VARCHAR(255),
  res_cam_address VARCHAR(1000),
  no_of_aval_accom BIGINT,
  no_of_occupied BIGINT,
  no_of_days_aval_food BIGINT,
  medical_ass_aval BOOLEAN,
  verified BOOLEAN
);
COMMENT ON TABLE rescue_camps IS 'Rescue camp metadata and capacity';

-- -----------------------------
-- End of migration
-- -----------------------------
-- Migration created for H2. For Postgres:
--   - Use CREATE SEQUENCE IF NOT EXISTS seq_name; and DEFAULT nextval('seq_name') for columns,
--     or use BIGSERIAL/BIGINT DEFAULT nextval('seq_name').
-- For MySQL:
--   - Replace sequences with BIGINT AUTO_INCREMENT columns and remove sequence creation.
