/**
 * Copyright (c) 2017, 2019 Kichwa Coders Ltd. and others.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0,
 * or the Eclipse Distribution License v. 1.0 which is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 * 
 * SPDX-License-Identifier: EPL-2.0 OR BSD-3-Clause
 */
package org.eclipse.lsp4j.debug;

import java.util.Arrays;
import org.eclipse.lsp4j.debug.BreakpointLocation;
import org.eclipse.lsp4j.debug.util.Preconditions;
import org.eclipse.lsp4j.jsonrpc.validation.NonNull;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

/**
 * Response to 'breakpointLocations' request.
 * <p>
 * Contains possible locations for source breakpoints.
 */
@SuppressWarnings("all")
public class BreakpointLocationsResponse {
  /**
   * Sorted set of possible breakpoint locations.
   */
  @NonNull
  private BreakpointLocation[] breakpoints;
  
  /**
   * Sorted set of possible breakpoint locations.
   */
  @Pure
  @NonNull
  public BreakpointLocation[] getBreakpoints() {
    return this.breakpoints;
  }
  
  /**
   * Sorted set of possible breakpoint locations.
   */
  public void setBreakpoints(@NonNull final BreakpointLocation[] breakpoints) {
    this.breakpoints = Preconditions.checkNotNull(breakpoints, "breakpoints");
  }
  
  @Override
  @Pure
  public String toString() {
    ToStringBuilder b = new ToStringBuilder(this);
    b.add("breakpoints", this.breakpoints);
    return b.toString();
  }
  
  @Override
  @Pure
  public boolean equals(final Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    BreakpointLocationsResponse other = (BreakpointLocationsResponse) obj;
    if (this.breakpoints == null) {
      if (other.breakpoints != null)
        return false;
    } else if (!Arrays.deepEquals(this.breakpoints, other.breakpoints))
      return false;
    return true;
  }
  
  @Override
  @Pure
  public int hashCode() {
    return 31 * 1 + ((this.breakpoints== null) ? 0 : Arrays.deepHashCode(this.breakpoints));
  }
}
