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
package org.apache.sis.services.csw.discovery;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.apache.sis.metadata.iso.extent.DefaultGeographicBoundingBox;
import org.apache.sis.referencing.IdentifiedObjects;
import org.apache.sis.util.iso.Types;
import org.opengis.metadata.Identifier;
import org.opengis.metadata.Metadata;
import org.opengis.metadata.MetadataScope;
import org.opengis.metadata.citation.Citation;
import org.opengis.metadata.citation.CitationDate;
import org.opengis.metadata.citation.DateType;
import org.opengis.metadata.citation.Party;
import org.opengis.metadata.citation.Responsibility;
import org.opengis.metadata.distribution.Distribution;
import org.opengis.metadata.distribution.Format;
import org.opengis.metadata.extent.Extent;
import org.opengis.metadata.extent.GeographicBoundingBox;
import org.opengis.metadata.extent.GeographicExtent;
import org.opengis.metadata.identification.Identification;
import org.opengis.metadata.identification.TopicCategory;
import org.opengis.metadata.lineage.Lineage;
import org.opengis.metadata.lineage.Source;
import org.opengis.metadata.maintenance.ScopeCode;
import org.opengis.util.InternationalString;

/**
 *
 * @author haonguyen
 */
@XmlType(name = "RecordType", namespace = Namespaces.CSW, propOrder = {
    "title",
    "creator",
    "subject",
    "description",
    "publisher",
    "contributor",
    "date",
    "type",
    "format",
    "identifier",
    "source",
    "language",
    "relation",
    "rights",
    "coverage",})
@XmlRootElement(name = "Record", namespace = Namespaces.CSW)

public class Record extends AbstractRecord {

    private String title;
    private String creator;
    private String subject;
    private String description;
    private String publisher;
    private String contributor;
    private Date date;
    private String type;
    private String format;
    private String identifier;
    private String source;
    private String language;
    private String relation;
    private BoundingBox coverage;
    private String rights;

    /**
     *
     * @return
     */
    @XmlElement(name = "title", namespace = Namespaces.DC)
    public String getTitle() {
        return title;
    }

    /**
     *
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     *
     * @return
     */
    @XmlElement(name = "creator", namespace = Namespaces.DC)
    public String getCreator() {
        return creator;
    }

    /**
     *
     * @param creator
     */
    public void setCreator(String creator) {
        this.creator = creator;
    }

    /**
     *
     * @return
     */
    @XmlElement(name = "subject", namespace = Namespaces.DC)
    public String getSubject() {
        return subject;
    }

    /**
     *
     * @param subject
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     *
     * @return
     */
    @XmlElement(name = "abstract", namespace = Namespaces.DCT)
    public String getDescription() {
        return description;
    }

    /**
     *
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     *
     * @return
     */
    @XmlElement(name = "publisher", namespace = Namespaces.DC)
    public String getPublisher() {
        return publisher;
    }

    /**
     *
     * @param publisher
     */
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    /**
     *
     * @return
     */
    @XmlElement(name = "contributor", namespace = Namespaces.DC)
    public String getContributor() {
        return contributor;
    }

    /**
     *
     * @param contributor
     */
    public void setContributor(String contributor) {
        this.contributor = contributor;
    }

    /**
     *
     * @return
     */
    @XmlElement(name = "modified", namespace = Namespaces.DCT)
    public Date getDate() {
        return date;
    }

    /**
     *
     * @param date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     *
     * @return
     */
    @XmlElement(name = "type", namespace = Namespaces.DC)
    public String getType() {
        return type;
    }

    /**
     *
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     *
     * @return
     */
    @XmlElement(name = "format", namespace = Namespaces.DC)
    public String getFormat() {
        return format;
    }

    /**
     *
     * @param format
     */
    public void setFormat(String format) {
        this.format = format;
    }

    /**
     *
     * @return
     */
    @XmlElement(name = "identifier", namespace = Namespaces.DC)
    public String getIdentifier() {
        return identifier;
    }

    /**
     *
     * @param identifier
     */
    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    /**
     *
     * @return
     */
    @XmlElement(name = "source", namespace = Namespaces.DC)
    public String getSource() {
        return source;
    }

    /**
     *
     * @param source
     */
    public void setSource(String source) {
        this.source = source;
    }

    /**
     *
     * @return
     */
    @XmlElement(name = "language", namespace = Namespaces.DC)
    public String getLanguage() {
        return language;
    }

    /**
     *
     * @param language
     */
    public void setLanguage(String language) {
        this.language = language;
    }

    /**
     *
     * @return
     */
    @XmlElement(name = "relation", namespace = Namespaces.DC)
    public String getRelation() {
        return relation;
    }

    /**
     *
     * @param relation
     */
    public void setRelation(String relation) {
        this.relation = relation;
    }

    /**
     *
     * @return
     */
    @XmlElement(name = "BoundingBox", namespace = Namespaces.OWS)
    public BoundingBox getCoverage() {
        return coverage;
    }

    /**
     *
     * @param coverage
     */
    public void setCoverage(BoundingBox coverage) {
        this.coverage = coverage;
    }

    /**
     *
     * @return
     */
    @XmlElement(name = "rights", namespace = Namespaces.DC)
    public String getRights() {
        return rights;
    }

    /**
     *
     * @param rights
     */
    public void setRights(String rights) {
        this.rights = rights;
    }

    /**
     *
     */
    public Record() {

    }

    /**
     *
     * @param metadata
     * @param locale
     */
    public Record(final Metadata metadata, final Locale locale) {
        /*
         * Get identifier and date information from the root metadata object. Note that:
         *
         *   - Identifier is optional in ISO 19115 but mandatory in <csw:Record>.
         *   - Date information is mandatory in ISO 19115.
         *
         * First, try to get those information from the paths specified by OGC 07-045.
         * They should be there, but if for some reason those information are missing,
         * then the loop below will search for fallbacks in resource citations.
         */
        identifier = IdentifiedObjects.toString(metadata.getMetadataIdentifier());              // May be null.
        setModified(metadata.getDateInfo());
        /*
         * Collect all titles, ignoring duplicated values. Opportunistically search for
         * dates and identifier to use as fallbacks if the above code did not found them.
         * Those fallbacks are specific to Apache SIS (not part of OGC 07-045).
         */
        GeographicBoundingBox bbox = null;
        DefaultGeographicBoundingBox union = null;
        final Set<String> titles = new HashSet<>();
        for (final Identification identification : metadata.getIdentificationInfo()) {
            if (identification != null) {
                final Citation citation = identification.getCitation();
                if (citation != null) {
                    final InternationalString i18n = citation.getTitle();
                    if (i18n != null) {
                        titles.add(i18n.toString(locale));
                    }
                    if (creator == null) {
                        for (final Responsibility responsibility : citation.getCitedResponsibleParties()) {
                            for (final Party party : responsibility.getParties()) {
                                creator = party.getName().toString();
                                if (creator != null) {
                                    break;
                                }
                            }
                        }
                    }
                    if (identifier == null) {
                        for (final Identifier id : citation.getIdentifiers()) {
                            identifier = IdentifiedObjects.toString(id);
                            if (identifier != null) {
                                break;                      // Stop at the first identifier.
                            }
                        }
                    }
                    if (format == null) {
                        for (final Format form : identification.getResourceFormats()) {
//                            for (final Citation name : form.getFormatSpecificationCitation()){
                            format = form.getFormatSpecificationCitation().getTitle().toString();
//                            }
                        }
                    }
                    if (subject == null) {
                        for (final TopicCategory topic : identification.getTopicCategories()) {
                            subject = topic.toString();
                        }
                    }
                    if (date == null) {
                        setModified(citation.getDates());
                    }
                }
                for (final Extent extent : identification.getExtents()) {
                    for (final GeographicExtent geo : extent.getGeographicElements()) {
                        if (geo instanceof GeographicBoundingBox) {
                            if (bbox == null) {
                                bbox = (GeographicBoundingBox) geo;
                            } else {
                                if (union == null) {
                                    bbox = union = new DefaultGeographicBoundingBox(bbox);
                                }
                                union.add((GeographicBoundingBox) geo);
                            }
                        }
                    }
                }
            }
        }
        if (bbox != null) {
            coverage = new BoundingBox(bbox);
        }
        if (language == null) {
            for (final Locale local : metadata.getLanguages()) {
                language = local.toString();
            }

        }
        title = toString(titles, System.lineSeparator());
        titles.clear();

        // Collect all formats, ignoring duplicated values.
        for (final Distribution distribution : metadata.getDistributionInfo()) {
            for (final Format df : distribution.getDistributionFormats()) {
                final Citation citation = df.getFormatSpecificationCitation();
                if (citation != null) {
                    for (final InternationalString i18n : citation.getAlternateTitles()) {
                        if (i18n != null) {
                            titles.add(i18n.toString(locale));
                        }
                    }
                }
            }
        }

        // Retain only the first type, if any.
        ScopeCode code = null;
        for (final MetadataScope scope : metadata.getMetadataScopes()) {
            code = scope.getResourceScope();
            if (code != null) {
                break;
            }
        }
        if (code == null) {
            code = ScopeCode.DATASET;       // Default value specified by OGC 07-045.
        }
        if (source == null) {
            for (final Lineage ligne : metadata.getResourceLineages()) {
                for (final Source sou : ligne.getSources()) {
                    source = sou.getDescription().toString();
                }
            }
        }

        type = Types.getCodeName(code);
    }

    private static String toString(final Set<String> items, final String separator) {
        items.remove(null);         // Safety in case the user metadata contains null elements.
        final Iterator<String> it = items.iterator();
        if (!it.hasNext()) {
            return null;
        }
        final String first = it.next();
        if (!it.hasNext()) {
            return first;            // Most common case: only one item in the set.
        }
        final StringBuilder buffer = new StringBuilder(first);
        while (it.hasNext()) {
            buffer.append(separator).append(it.next());
        }
        return buffer.toString();
    }

    private void setModified(final Collection<? extends CitationDate> dates) {
        if (dates != null) {                            // Paranoiac check.
            for (final CitationDate date1 : dates) {
                final DateType dt = date1.getDateType();
                if (DateType.CREATION.equals(dt) || DateType.LAST_UPDATE.equals(dt)) {
                    final Date t = date1.getDate();
                    if (t != null) {
                        if (date == null || t.after(date)) {
                            date = t;
                        }
                    }
                }
            }
        }
    }

    @Override
    public String toString() {
        return "Record{" + "title=" + title + ", creator=" + creator + ", subject=" + subject + ", description=" + description + ", publisher=" + publisher + ", contributor=" + contributor + ", date=" + date + ", type=" + type + ", format=" + format + ", identifier=" + identifier + ", source=" + source + ", language=" + language + ", relation=" + relation + ", coverage=" + coverage + ", rights=" + rights + '}';
    } 
}
