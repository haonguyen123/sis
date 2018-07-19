/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.sis.measure;

import javax.measure.Quantity;


/**
 * The Practical Salinity Scale (PSS-78).
 * This is a dimensionless quantity for the measurement of sea water salinity.
 * In principle, the unit of measurement associated to this quantity has no symbol.
 * However Apache SIS uses the "psu" symbol for avoiding confusion with other dimensionless units.
 *
 * <p>Most quantity types are defined in the {@link javax.measure.quantity}.
 * This {@code Salinity} type is an extension to the standard types.</p>
 *
 * @author  Martin Desruisseaux (Geomatys)
 * @version 0.8
 * @since   0.8
 * @module
 *
 * @see Units#PSU
 * @see AngularVelocity
 */
public interface Salinity extends Quantity<Salinity> {
}
