/**
 * Copyright (c) 2014-2016 by the respective copyright holders.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.openhab.binding.zwave.internal.protocol;

import static org.openhab.binding.zwave.internal.protocol.commandclass.ZWaveCommandClass.CommandClass.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.openhab.binding.zwave.internal.protocol.commandclass.ZWaveCommandClass.CommandClass;

/**
 * Z-Wave Plus device type class. Defines the zwave plus device types and the mandatory command classes.
 *
 * @author Jorg de Jong
 */
public class ZWavePlusDeviceClass {

    public enum ZWavePlusDeviceType {
        // @formatter:off
        UNKNOWN_TYPE(0x0000),
        CENTRAL_CONTROLLER(0x0100, DEVICE_RESET_LOCALLY, ZWAVE_PLUS_INFO, ASSOCIATION_GROUP_INFO, MANUFACTURER_SPECIFIC, POWERLEVEL, ASSOCIATION, VERSION, CRC_16_ENCAP, APPLICATION_STATUS),
        DISPLAY_SIMPLE(0x0200, DEVICE_RESET_LOCALLY, ZWAVE_PLUS_INFO, ASSOCIATION_GROUP_INFO, MANUFACTURER_SPECIFIC, POWERLEVEL, ASSOCIATION, VERSION),
        DOOR_LOCK_KEYPAD(0x0300, DEVICE_RESET_LOCALLY, ZWAVE_PLUS_INFO, ASSOCIATION_GROUP_INFO, MANUFACTURER_SPECIFIC, POWERLEVEL, ASSOCIATION, VERSION, DOOR_LOCK, USER_CODE, BATTERY),
        FAN_SWITCH(0x0400, DEVICE_RESET_LOCALLY, ZWAVE_PLUS_INFO, ASSOCIATION_GROUP_INFO, MANUFACTURER_SPECIFIC, POWERLEVEL, ASSOCIATION, VERSION, SWITCH_MULTILEVEL),
        GATEWAY(0x0500, DEVICE_RESET_LOCALLY, ZWAVE_PLUS_INFO, ASSOCIATION_GROUP_INFO, MANUFACTURER_SPECIFIC, POWERLEVEL, ASSOCIATION, VERSION, CRC_16_ENCAP, MULTI_INSTANCE, MULTI_INSTANCE_ASSOCIATION, WAKE_UP,APPLICATION_STATUS),
        LIGHT_DIMMER_SWITCH(0x0600, DEVICE_RESET_LOCALLY, ZWAVE_PLUS_INFO, ASSOCIATION_GROUP_INFO, MANUFACTURER_SPECIFIC, POWERLEVEL, ASSOCIATION, VERSION, SWITCH_MULTILEVEL),
        ON_OFF_POWER_SWITCH(0x0700, DEVICE_RESET_LOCALLY, ZWAVE_PLUS_INFO, ASSOCIATION_GROUP_INFO, MANUFACTURER_SPECIFIC, POWERLEVEL, ASSOCIATION, VERSION, SWITCH_BINARY),
        POWER_STRIP(0x0800, DEVICE_RESET_LOCALLY, ZWAVE_PLUS_INFO, ASSOCIATION_GROUP_INFO, MANUFACTURER_SPECIFIC, POWERLEVEL, ASSOCIATION, VERSION, MULTI_INSTANCE, MULTI_INSTANCE_ASSOCIATION, SWITCH_BINARY),
        REMOTE_CONTROL_AV(0x0900, DEVICE_RESET_LOCALLY, ZWAVE_PLUS_INFO, ASSOCIATION_GROUP_INFO, MANUFACTURER_SPECIFIC, POWERLEVEL, ASSOCIATION, VERSION),
        REMOTE_CONTROL_MULTI_PURPOSE(0x0a00, DEVICE_RESET_LOCALLY, ZWAVE_PLUS_INFO, ASSOCIATION_GROUP_INFO, MANUFACTURER_SPECIFIC, POWERLEVEL, ASSOCIATION, VERSION,WAKE_UP),
        REMOTE_CONTROL_SIMPLE(0x0b00, DEVICE_RESET_LOCALLY, ZWAVE_PLUS_INFO, ASSOCIATION_GROUP_INFO, MANUFACTURER_SPECIFIC, POWERLEVEL, ASSOCIATION, VERSION, CENTRAL_SCENE),
        KEY_FOB(0x0b01, DEVICE_RESET_LOCALLY, ZWAVE_PLUS_INFO, ASSOCIATION_GROUP_INFO, MANUFACTURER_SPECIFIC, POWERLEVEL, ASSOCIATION, VERSION, CENTRAL_SCENE),
        SENSOR_NOTIFICATION(0x0c00, DEVICE_RESET_LOCALLY, ZWAVE_PLUS_INFO, ASSOCIATION_GROUP_INFO, MANUFACTURER_SPECIFIC, POWERLEVEL, ASSOCIATION, VERSION, SENSOR_BINARY),
        SMOKE_ALARM_SENSOR(0x0c01, DEVICE_RESET_LOCALLY, ZWAVE_PLUS_INFO, ASSOCIATION_GROUP_INFO, MANUFACTURER_SPECIFIC, POWERLEVEL, ASSOCIATION, VERSION, SENSOR_BINARY),
        CO_ALARM_SENSOR(0x0c02, DEVICE_RESET_LOCALLY, ZWAVE_PLUS_INFO, ASSOCIATION_GROUP_INFO, MANUFACTURER_SPECIFIC, POWERLEVEL, ASSOCIATION, VERSION, SENSOR_BINARY),
        CO2_ALARM_SENSOR(0x0c03, DEVICE_RESET_LOCALLY, ZWAVE_PLUS_INFO, ASSOCIATION_GROUP_INFO, MANUFACTURER_SPECIFIC, POWERLEVEL, ASSOCIATION, VERSION, SENSOR_BINARY),
        HEAT_ALARM_SENSOR(0x0c04, DEVICE_RESET_LOCALLY, ZWAVE_PLUS_INFO, ASSOCIATION_GROUP_INFO, MANUFACTURER_SPECIFIC, POWERLEVEL, ASSOCIATION, VERSION, SENSOR_BINARY),
        WATER_ALARM_SENSOR(0x0c05, DEVICE_RESET_LOCALLY, ZWAVE_PLUS_INFO, ASSOCIATION_GROUP_INFO, MANUFACTURER_SPECIFIC, POWERLEVEL, ASSOCIATION, VERSION, SENSOR_BINARY),
        ACCESS_CONTROL_SENSOR(0x0c06, DEVICE_RESET_LOCALLY, ZWAVE_PLUS_INFO, ASSOCIATION_GROUP_INFO, MANUFACTURER_SPECIFIC, POWERLEVEL, ASSOCIATION, VERSION, SENSOR_BINARY),
        HOME_SECURITY_SENSOR(0x0c07, DEVICE_RESET_LOCALLY, ZWAVE_PLUS_INFO, ASSOCIATION_GROUP_INFO, MANUFACTURER_SPECIFIC, POWERLEVEL, ASSOCIATION, VERSION, SENSOR_BINARY),
        POWER_MANAGEMENT_SENSOR(0x0c08, DEVICE_RESET_LOCALLY, ZWAVE_PLUS_INFO, ASSOCIATION_GROUP_INFO, MANUFACTURER_SPECIFIC, POWERLEVEL, ASSOCIATION, VERSION, SENSOR_BINARY),
        SYSTEM_SENSOR(0x0c09, DEVICE_RESET_LOCALLY, ZWAVE_PLUS_INFO, ASSOCIATION_GROUP_INFO, MANUFACTURER_SPECIFIC, POWERLEVEL, ASSOCIATION, VERSION, SENSOR_BINARY),
        EMERGENCY_ALARM_SENSOR(0x0c0a, DEVICE_RESET_LOCALLY, ZWAVE_PLUS_INFO, ASSOCIATION_GROUP_INFO, MANUFACTURER_SPECIFIC, POWERLEVEL, ASSOCIATION, VERSION, SENSOR_BINARY),
        CLOCK_SENSOR(0x0c0b, DEVICE_RESET_LOCALLY, ZWAVE_PLUS_INFO, ASSOCIATION_GROUP_INFO, MANUFACTURER_SPECIFIC, POWERLEVEL, ASSOCIATION, VERSION, SENSOR_BINARY),
        MULTIDEVICE_NOTIFICATION_SENSOR(0x0cff, DEVICE_RESET_LOCALLY, ZWAVE_PLUS_INFO, ASSOCIATION_GROUP_INFO, MANUFACTURER_SPECIFIC, POWERLEVEL, ASSOCIATION, VERSION, SENSOR_BINARY),
        MULTILEVEL_SENSOR(0x0d00, DEVICE_RESET_LOCALLY, ZWAVE_PLUS_INFO, ASSOCIATION_GROUP_INFO, MANUFACTURER_SPECIFIC, POWERLEVEL, ASSOCIATION, VERSION, SENSOR_BINARY, SENSOR_MULTILEVEL),
        AIR_TEMPERATURE_SENSOR(0x0d01, DEVICE_RESET_LOCALLY, ZWAVE_PLUS_INFO, ASSOCIATION_GROUP_INFO, MANUFACTURER_SPECIFIC, POWERLEVEL, ASSOCIATION, VERSION, SENSOR_BINARY, SENSOR_MULTILEVEL),
        GENERAL_PURPOSE_SENSOR(0x0d02, DEVICE_RESET_LOCALLY, ZWAVE_PLUS_INFO, ASSOCIATION_GROUP_INFO, MANUFACTURER_SPECIFIC, POWERLEVEL, ASSOCIATION, VERSION, SENSOR_BINARY, SENSOR_MULTILEVEL),
        LUMINANCE_SENSOR(0x0d03, DEVICE_RESET_LOCALLY, ZWAVE_PLUS_INFO, ASSOCIATION_GROUP_INFO, MANUFACTURER_SPECIFIC, POWERLEVEL, ASSOCIATION, VERSION, SENSOR_BINARY, SENSOR_MULTILEVEL),
        POWER_SENSOR(0x0d04, DEVICE_RESET_LOCALLY, ZWAVE_PLUS_INFO, ASSOCIATION_GROUP_INFO, MANUFACTURER_SPECIFIC, POWERLEVEL, ASSOCIATION, VERSION, SENSOR_BINARY, SENSOR_MULTILEVEL),
        HUMIDITY_SENSOR(0x0d05, DEVICE_RESET_LOCALLY, ZWAVE_PLUS_INFO, ASSOCIATION_GROUP_INFO, MANUFACTURER_SPECIFIC, POWERLEVEL, ASSOCIATION, VERSION, SENSOR_BINARY, SENSOR_MULTILEVEL),
        VELOCITY_SENSOR(0x0d06, DEVICE_RESET_LOCALLY, ZWAVE_PLUS_INFO, ASSOCIATION_GROUP_INFO, MANUFACTURER_SPECIFIC, POWERLEVEL, ASSOCIATION, VERSION, SENSOR_BINARY, SENSOR_MULTILEVEL),
        DIRECTION_SENSOR(0x0d07, DEVICE_RESET_LOCALLY, ZWAVE_PLUS_INFO, ASSOCIATION_GROUP_INFO, MANUFACTURER_SPECIFIC, POWERLEVEL, ASSOCIATION, VERSION, SENSOR_BINARY, SENSOR_MULTILEVEL),
        ATMOSPHERIC_PRESSURE_SENSOR(0x0d08, DEVICE_RESET_LOCALLY, ZWAVE_PLUS_INFO, ASSOCIATION_GROUP_INFO, MANUFACTURER_SPECIFIC, POWERLEVEL, ASSOCIATION, VERSION, SENSOR_BINARY, SENSOR_MULTILEVEL),
        BAROMETRIC_PRESSURE_SENSOR(0x0d09, DEVICE_RESET_LOCALLY, ZWAVE_PLUS_INFO, ASSOCIATION_GROUP_INFO, MANUFACTURER_SPECIFIC, POWERLEVEL, ASSOCIATION, VERSION, SENSOR_BINARY, SENSOR_MULTILEVEL),
        SOLAR_RADIATION_SENSOR(0x0d0a, DEVICE_RESET_LOCALLY, ZWAVE_PLUS_INFO, ASSOCIATION_GROUP_INFO, MANUFACTURER_SPECIFIC, POWERLEVEL, ASSOCIATION, VERSION, SENSOR_BINARY, SENSOR_MULTILEVEL),
        DEW_POINT_SENSOR(0x0d0b, DEVICE_RESET_LOCALLY, ZWAVE_PLUS_INFO, ASSOCIATION_GROUP_INFO, MANUFACTURER_SPECIFIC, POWERLEVEL, ASSOCIATION, VERSION, SENSOR_BINARY, SENSOR_MULTILEVEL),
        RAIN_RATE_SENSOR(0x0d0c, DEVICE_RESET_LOCALLY, ZWAVE_PLUS_INFO, ASSOCIATION_GROUP_INFO, MANUFACTURER_SPECIFIC, POWERLEVEL, ASSOCIATION, VERSION, SENSOR_BINARY, SENSOR_MULTILEVEL),
        TIDE_LEVEL_SENSOR(0x0d0d, DEVICE_RESET_LOCALLY, ZWAVE_PLUS_INFO, ASSOCIATION_GROUP_INFO, MANUFACTURER_SPECIFIC, POWERLEVEL, ASSOCIATION, VERSION, SENSOR_BINARY, SENSOR_MULTILEVEL),
        WEIGHT_SENSOR(0x0d0e, DEVICE_RESET_LOCALLY, ZWAVE_PLUS_INFO, ASSOCIATION_GROUP_INFO, MANUFACTURER_SPECIFIC, POWERLEVEL, ASSOCIATION, VERSION, SENSOR_BINARY, SENSOR_MULTILEVEL),
        VOLTAGE_SENSOR(0x0d0f, DEVICE_RESET_LOCALLY, ZWAVE_PLUS_INFO, ASSOCIATION_GROUP_INFO, MANUFACTURER_SPECIFIC, POWERLEVEL, ASSOCIATION, VERSION, SENSOR_BINARY, SENSOR_MULTILEVEL),
        CURRENT_SENSOR(0x0d10, DEVICE_RESET_LOCALLY, ZWAVE_PLUS_INFO, ASSOCIATION_GROUP_INFO, MANUFACTURER_SPECIFIC, POWERLEVEL, ASSOCIATION, VERSION, SENSOR_BINARY, SENSOR_MULTILEVEL),
        CO2_LEVEL_SENSOR(0x0d11, DEVICE_RESET_LOCALLY, ZWAVE_PLUS_INFO, ASSOCIATION_GROUP_INFO, MANUFACTURER_SPECIFIC, POWERLEVEL, ASSOCIATION, VERSION, SENSOR_BINARY, SENSOR_MULTILEVEL),
        AIR_FLOW_SENSOR(0x0d12, DEVICE_RESET_LOCALLY, ZWAVE_PLUS_INFO, ASSOCIATION_GROUP_INFO, MANUFACTURER_SPECIFIC, POWERLEVEL, ASSOCIATION, VERSION, SENSOR_BINARY, SENSOR_MULTILEVEL),
        TANK_CAPACITY_SENSOR(0x0d13, DEVICE_RESET_LOCALLY, ZWAVE_PLUS_INFO, ASSOCIATION_GROUP_INFO, MANUFACTURER_SPECIFIC, POWERLEVEL, ASSOCIATION, VERSION, SENSOR_BINARY, SENSOR_MULTILEVEL),
        DISTANCE_SENSOR(0x0d14, DEVICE_RESET_LOCALLY, ZWAVE_PLUS_INFO, ASSOCIATION_GROUP_INFO, MANUFACTURER_SPECIFIC, POWERLEVEL, ASSOCIATION, VERSION, SENSOR_BINARY, SENSOR_MULTILEVEL),
        ANGLE_POSITION_SENSOR(0x0d15, DEVICE_RESET_LOCALLY, ZWAVE_PLUS_INFO, ASSOCIATION_GROUP_INFO, MANUFACTURER_SPECIFIC, POWERLEVEL, ASSOCIATION, VERSION, SENSOR_BINARY, SENSOR_MULTILEVEL),
        ROTATION_SENSOR(0x0d16, DEVICE_RESET_LOCALLY, ZWAVE_PLUS_INFO, ASSOCIATION_GROUP_INFO, MANUFACTURER_SPECIFIC, POWERLEVEL, ASSOCIATION, VERSION, SENSOR_BINARY, SENSOR_MULTILEVEL),
        WATER_TEMPERATURE_SENSOR(0x0d17, DEVICE_RESET_LOCALLY, ZWAVE_PLUS_INFO, ASSOCIATION_GROUP_INFO, MANUFACTURER_SPECIFIC, POWERLEVEL, ASSOCIATION, VERSION, SENSOR_BINARY, SENSOR_MULTILEVEL),
        SOIL_TEMPERATURE_SENSOR(0x0d18, DEVICE_RESET_LOCALLY, ZWAVE_PLUS_INFO, ASSOCIATION_GROUP_INFO, MANUFACTURER_SPECIFIC, POWERLEVEL, ASSOCIATION, VERSION, SENSOR_BINARY, SENSOR_MULTILEVEL),
        SEISMIC_INTENSITY_SENSOR(0x0d19, DEVICE_RESET_LOCALLY, ZWAVE_PLUS_INFO, ASSOCIATION_GROUP_INFO, MANUFACTURER_SPECIFIC, POWERLEVEL, ASSOCIATION, VERSION, SENSOR_BINARY, SENSOR_MULTILEVEL),
        SEISMIC_MAGNITUDE_SENSOR(0x0d1a, DEVICE_RESET_LOCALLY, ZWAVE_PLUS_INFO, ASSOCIATION_GROUP_INFO, MANUFACTURER_SPECIFIC, POWERLEVEL, ASSOCIATION, VERSION, SENSOR_BINARY, SENSOR_MULTILEVEL),
        ULTRAVIOLET_SENSOR(0x0d1b, DEVICE_RESET_LOCALLY, ZWAVE_PLUS_INFO, ASSOCIATION_GROUP_INFO, MANUFACTURER_SPECIFIC, POWERLEVEL, ASSOCIATION, VERSION, SENSOR_BINARY, SENSOR_MULTILEVEL),
        ELECTRICAL_RESISTIVITY_SENSOR(0x0d1c, DEVICE_RESET_LOCALLY, ZWAVE_PLUS_INFO, ASSOCIATION_GROUP_INFO, MANUFACTURER_SPECIFIC, POWERLEVEL, ASSOCIATION, VERSION, SENSOR_BINARY, SENSOR_MULTILEVEL),
        ELECTRICAL_CONDUCTIVITY_SENSOR(0x0b1d, DEVICE_RESET_LOCALLY, ZWAVE_PLUS_INFO, ASSOCIATION_GROUP_INFO, MANUFACTURER_SPECIFIC, POWERLEVEL, ASSOCIATION, VERSION, SENSOR_BINARY, SENSOR_MULTILEVEL),
        LOUDNESS_SENSOR(0x0b1e, DEVICE_RESET_LOCALLY, ZWAVE_PLUS_INFO, ASSOCIATION_GROUP_INFO, MANUFACTURER_SPECIFIC, POWERLEVEL, ASSOCIATION, VERSION, SENSOR_BINARY, SENSOR_MULTILEVEL),
        MOISTURE_SENSOR(0x0b1f, DEVICE_RESET_LOCALLY, ZWAVE_PLUS_INFO, ASSOCIATION_GROUP_INFO, MANUFACTURER_SPECIFIC, POWERLEVEL, ASSOCIATION, VERSION, SENSOR_BINARY, SENSOR_MULTILEVEL),
        FREQUENCY_SENSOR(0x0b20, DEVICE_RESET_LOCALLY, ZWAVE_PLUS_INFO, ASSOCIATION_GROUP_INFO, MANUFACTURER_SPECIFIC, POWERLEVEL, ASSOCIATION, VERSION, SENSOR_BINARY, SENSOR_MULTILEVEL),
        TIME_SENSOR(0x0b21, DEVICE_RESET_LOCALLY, ZWAVE_PLUS_INFO, ASSOCIATION_GROUP_INFO, MANUFACTURER_SPECIFIC, POWERLEVEL, ASSOCIATION, VERSION, SENSOR_BINARY, SENSOR_MULTILEVEL),
        TARGET_TEMPERATURE_SENSOR(0x0b22, DEVICE_RESET_LOCALLY, ZWAVE_PLUS_INFO, ASSOCIATION_GROUP_INFO, MANUFACTURER_SPECIFIC, POWERLEVEL, ASSOCIATION, VERSION, SENSOR_BINARY, SENSOR_MULTILEVEL),
        MULTIDEVICE_SENSOR(0x0bff, DEVICE_RESET_LOCALLY, ZWAVE_PLUS_INFO, ASSOCIATION_GROUP_INFO, MANUFACTURER_SPECIFIC, POWERLEVEL, ASSOCIATION, VERSION, SENSOR_BINARY, SENSOR_MULTILEVEL),
        SET_TOP_BOX(0x0e00, DEVICE_RESET_LOCALLY, ZWAVE_PLUS_INFO, ASSOCIATION_GROUP_INFO, MANUFACTURER_SPECIFIC, POWERLEVEL, ASSOCIATION, VERSION, CRC_16_ENCAP, MULTI_INSTANCE, MULTI_INSTANCE_ASSOCIATION, WAKE_UP, APPLICATION_STATUS),
        SIREN(0x0f00, DEVICE_RESET_LOCALLY, ZWAVE_PLUS_INFO, ASSOCIATION_GROUP_INFO, MANUFACTURER_SPECIFIC, POWERLEVEL, ASSOCIATION, VERSION),
        SUB_ENERGY_METER(0x1000, DEVICE_RESET_LOCALLY, ZWAVE_PLUS_INFO, ASSOCIATION_GROUP_INFO, MANUFACTURER_SPECIFIC, POWERLEVEL, ASSOCIATION, VERSION, CRC_16_ENCAP, METER),
        SUB_SYSTEM_CONTROLLER(0x1100, DEVICE_RESET_LOCALLY, ZWAVE_PLUS_INFO, ASSOCIATION_GROUP_INFO, MANUFACTURER_SPECIFIC, POWERLEVEL, ASSOCIATION, VERSION, MULTI_INSTANCE, WAKE_UP, APPLICATION_STATUS),
        THERMOSTAT_HVAC(0x1200, DEVICE_RESET_LOCALLY, ZWAVE_PLUS_INFO, ASSOCIATION_GROUP_INFO, MANUFACTURER_SPECIFIC, POWERLEVEL, ASSOCIATION, VERSION, THERMOSTAT_SETPOINT, THERMOSTAT_MODE),
        THERMOSTAT_SETBACK(0x1300, DEVICE_RESET_LOCALLY, ZWAVE_PLUS_INFO, ASSOCIATION_GROUP_INFO, MANUFACTURER_SPECIFIC, POWERLEVEL, ASSOCIATION, VERSION, THERMOSTAT_SETPOINT),
        TV(0x1400, DEVICE_RESET_LOCALLY, ZWAVE_PLUS_INFO, ASSOCIATION_GROUP_INFO, MANUFACTURER_SPECIFIC, POWERLEVEL, ASSOCIATION, VERSION, CRC_16_ENCAP, MULTI_INSTANCE, MULTI_INSTANCE_ASSOCIATION, WAKE_UP, APPLICATION_STATUS),
        VALVE_OPEN_CLOSE(0x1500, DEVICE_RESET_LOCALLY, ZWAVE_PLUS_INFO, ASSOCIATION_GROUP_INFO, MANUFACTURER_SPECIFIC, POWERLEVEL, ASSOCIATION, VERSION, SWITCH_MULTILEVEL, SWITCH_BINARY),
        WALL_CONTROLLER(0x1600, DEVICE_RESET_LOCALLY, ZWAVE_PLUS_INFO, ASSOCIATION_GROUP_INFO, MANUFACTURER_SPECIFIC, POWERLEVEL, ASSOCIATION, VERSION, CENTRAL_SCENE),
        WHOLE_HOME_METER_SIMPLE(0x1700, DEVICE_RESET_LOCALLY, ZWAVE_PLUS_INFO, ASSOCIATION_GROUP_INFO, MANUFACTURER_SPECIFIC, POWERLEVEL, ASSOCIATION, VERSION, CRC_16_ENCAP, METER),
        WINDOW_COVERING_NO_POSITION_ENDPOINT(0x1800, DEVICE_RESET_LOCALLY, ZWAVE_PLUS_INFO, ASSOCIATION_GROUP_INFO, MANUFACTURER_SPECIFIC, POWERLEVEL, ASSOCIATION,VERSION, SWITCH_MULTILEVEL, SWITCH_BINARY),
        WINDOW_COVERING_ENDPOINT_AWARE(0x1900, DEVICE_RESET_LOCALLY, ZWAVE_PLUS_INFO, ASSOCIATION_GROUP_INFO, MANUFACTURER_SPECIFIC, POWERLEVEL, ASSOCIATION, VERSION, SWITCH_MULTILEVEL, SWITCH_BINARY),
        WINDOW_COVERING_POSITION_ENDPOINT_AWARE(0x1a00, DEVICE_RESET_LOCALLY, ZWAVE_PLUS_INFO, ASSOCIATION_GROUP_INFO, MANUFACTURER_SPECIFIC, POWERLEVEL, ASSOCIATION, VERSION, SWITCH_MULTILEVEL, SWITCH_BINARY);
        // @formatter:on

        private static Map<Integer, ZWavePlusDeviceType> zwavePlusDeviceTypes = new HashMap<>();

        private int key;
        private Set<CommandClass> mandatoryCommandClasses = new HashSet<>();

        ZWavePlusDeviceType(int key, CommandClass... classes) {
            this.key = key;
            mandatoryCommandClasses.addAll(Arrays.asList(classes));
        }

        public int getKey() {
            return key;
        }

        public Set<CommandClass> getMandatoryCommandClasses() {
            return mandatoryCommandClasses;
        }

        private static void setup() {
            for (ZWavePlusDeviceType type : ZWavePlusDeviceType.values()) {
                zwavePlusDeviceTypes.put(type.getKey(), type);
            }
        }

        /**
         * Lookup the zwavePlus Device info.
         *
         * @param zwPlusDeviceType the device type
         * @return the device info if available
         */
        public static ZWavePlusDeviceType getZWavePlusDeviceType(int zwPlusDeviceType) {
            if (zwavePlusDeviceTypes.isEmpty()) {
                setup();
            }
            return zwavePlusDeviceTypes.get(zwPlusDeviceType);
        }
    }
}
