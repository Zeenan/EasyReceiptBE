package com.papafranku.utilities;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.papafranku.entities.ResponseStatus;

public class WebUtilities {
	
	public static boolean isEmpty(Object value) {
        if (null == value) {
            return true;
        }
        
        if (value instanceof String) {
            if (value.equals("")) {
                return true;
            }
        } else if (value instanceof Integer) {
            if (0 == ((Integer)value).intValue()) {
                return true;
            }
        } else if (value instanceof Long) {
            if (0l == ((Long)value).longValue()) {
                return true;
            }
        } else if (value instanceof Double) {
            if (0d == ((Double)value).doubleValue()) {
                return true;
            }
        } else if (value instanceof Float) {
            if (0f == ((Float)value).floatValue()) {
                return true;
            }
        } else if (value instanceof Short) {
            if (0 == ((Short)value).shortValue()) {
                return true;
            }
        } else if (value instanceof Byte) {
            if (0 == ((Byte)value).byteValue()) {
                return true;
            }
        } else if (value instanceof BigInteger) {
            if (0 == ((BigInteger)value).longValue()) {
                return true;
            }
        } else if (value instanceof BigDecimal) {
            if (0 == ((BigDecimal)value).doubleValue()) {
                return true;
            }
        } else if (value instanceof BigInteger) {
            if (0 == ((BigInteger)value).longValue()) {
                return true;
            }
        } else if (value instanceof AtomicLong) {
            if (0 == ((AtomicLong)value).longValue()) {
                return true;
            }
        } else if (value instanceof AtomicInteger) {
            if (0 == ((AtomicInteger)value).intValue()) {
                return true;
            }
        } else if (value instanceof List) {
            if (0 == ((List)value).size()) {
                return true;
            }
        } else if (value instanceof Map) {
            if (0 == ((Map)value).size()) {
                return true;
            }
        } else if (value.getClass().isArray()) {
            if (0 == Arrays.asList(value).size()) {
                return true;
            }
        }
        return false;
    }
	
	public static ResponseEntity<ResponseStatus> getResponse(ResponseStatus status) {
        ResponseEntity<ResponseStatus> response = null;
        HttpStatus http_status = null;
        
        if (null != status) {
            if (null == status.getCode()) {
                http_status = HttpStatus.OK;
            } else {
                http_status = HttpStatus.valueOf(status.getCode());
                
                //remove code so that it will not show on the json body resp
                if (/*!status.getClass().getName().equals(Status.class.getName()) &&*/ WebUtilities.isEmpty(status.getCode())) {
                    status.setCode(null);
                }
                
            }

            if (!WebUtilities.isEmpty(status.getResults())) {
                for (Object entry : status.getResults()) {
                	// do anything here. Like Cache daw.
                }
            }
            
            response = new ResponseEntity<ResponseStatus>(status, http_status);
        }
        return response;
    }

}
