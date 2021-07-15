package com.thanhtai.healthdeclarationinformation.mapper;

public final class EnumMapper {

  public String toString(final Enum<?> e) {
    if (e == null) {
      return null;
    }
    return e.toString();
  }
}
