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
import java.util.Comparator;
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
    /**
     * A name given to the resource. 
     * Typically, Title will be a name by which the resource is formally known.
     */
    private String title;
    /**
     * An entity primarily responsible for making the content of the resource. 
     * Examples of Creator include a person, an organization, or a service. 
     * Typically, the name of a Creator should be used to indicate the entity.
     */
    private String creator;
    /**
     * A topic of the content of the resource. 
     * Typically, Subject will be expressed as keywords, key phrases, or 
     * classification codes that describe a topic of the resource. Recommended 
     * best practice is to select a value from a controlled vocabulary or formal 
     * classification scheme.
     */
    private String subject;
    /**
     * An account of the content of the resource. 
     * Examples of Description include, but are not limited to, an abstract, 
     * table of contents, reference to a graphical representation of content, 
     * or free-text account of the content.
     */
    private String description;
    /**
     * An entity responsible for making the resource available. 
     * Examples of Publisher include a person, an organization, or a service. 
     * Typically, the name of a Publisher should be used to indicate the entity.
     */
    private String publisher;
    /**
     * An entity responsible for making contributions to the content of the resource. 
     * Examples of Contributor include a person, an organization, or a service. 
     * Typically, the name of a Contributor should be used to indicate the entity.
     */
    private String contributor;
    /**
     * A date of an event in the lifecycle of the resource. 
     * Typically, Date will be associated with the creation or availability of 
     * the resource. Recommended best practice for encoding the date value is 
     * defined in a profile of ISO 8601 and includes (among others) dates of the form YYYY-MM-DD.
     */
    private Date date;
    /**
     * The nature or genre of the content of the resource. 
     * Type includes terms describing general categories, functions, genres, 
     * or aggregation levels for content. Recommended best practice is to select 
     * a value from a controlled vocabulary (for example, the DCMI Type Vocabulary). 
     * To describe the physical or digital manifestation of the resource, use the 
     * Format element.
     */
    private String type;
    /**
     * The physical or digital manifestation of the resource. 
     * Typically, Format will include the media-type or dimensions of the resource. 
     * Format may be used to identify the software, hardware, or other equipment 
     * needed to display or operate the resource. Examples of dimensions include 
     * size and duration. Recommended best practice is to select a value from a 
     * controlled vocabulary (for example, the list of Internet Media Types defining 
     * computer media formats).
     */
    private String format;
    /**
     * An unambiguous reference to the resource within a given context. 
     * Recommended best practice is to identify the resource by means of a string 
     * or number conforming to a formal identification system. Formal identification 
     * systems include but are not limited to the Uniform Resource Identifier (URI) 
     * (including the Uniform Resource Locator (URL)), the Digital Object Identifier 
     * (DOI), and the International Standard Book Number (ISBN).
     */
    private String identifier;
    /**
     * A Reference to a resource from which the present resource is derived. 
     * The present resource may be derived from the Source resource in whole or 
     * in part. Recommended best practice is to identify the referenced resource 
     * by means of a string or number conforming to a formal identification system.
     */
    private String source;
    /**
     * A language of the intellectual content of the resource. 
     * Recommended best practice is to use RFC 3066, which, in conjunction with 
     * ISO 639, defines two- and three-letter primary language tags with optional 
     * subtags. Examples include "en" or "eng" for English, "akk" for Akkadian, 
     * and "en-GB" for English used in the United Kingdom.
     */
    private String language;
    /**
     * A reference to a related resource. 
     * Recommended best practice is to identify the referenced resource by means 
     * of a string or number conforming to a formal identification system.
     */
    private String relation;
    /**
     * The extent or scope of the content of the resource. 
     * Typically, Coverage will include spatial location (a place name or geographic coordinates), 
     * temporal period (a period label, date, or date range), or jurisdiction 
     * (such as a named administrative entity). Recommended best practice is to 
     * select a value from a controlled vocabulary (for example, the Thesaurus of 
     * Geographic Names [TGN]) and to use, where appropriate, named places or 
     * time periods in preference to numeric identifiers such as sets of coordinates 
     * or date ranges.
     */
    private BoundingBox coverage;
    /**
     * Information about rights held in and over the resource. 
     * Typically, Rights will contain a rights management statement for the 
     * resource, or reference a service providing such information. 
     * Rights information often encompasses Intellectual Property Rights (IPR), 
     * Copyright, and various Property Rights. If the Rights element is absent, 
     * no assumptions may be made about any rights held in or over the resource.
     */
    private String rights;

    /**
     * Return A name given to the resource. 
     * @return A name given to the resource. 
     */
    @XmlElement(name = "title", namespace = Namespaces.DC)
    public String getTitle() {
        return title;
    }

    /**
     * Set A name given to the resource. 
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Return An entity primarily responsible for making the content of the resource. 
     * @return A topic of the content of the resource. 
     */
    @XmlElement(name = "creator", namespace = Namespaces.DC)
    public String getCreator() {
        return creator;
    }

    /**
     * Set An entity primarily responsible for making the content of the resource. 
     * @param creator
     */
    public void setCreator(String creator) {
        this.creator = creator;
    }

    /**
     * Return A topic of the content of the resource. 
     * @return A topic of the content of the resource. 
     */
    @XmlElement(name = "subject", namespace = Namespaces.DC)
    public String getSubject() {
        return subject;
    }

    /**
     * Set A topic of the content of the resource. 
     * @param subject
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * Return An account of the content of the resource.
     * @return An account of the content of the resource.
     */
    @XmlElement(name = "abstract", namespace = Namespaces.DCT)
    public String getDescription() {
        return description;
    }

    /**
     * Set An account of the content of the resource.
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Return An entity responsible for making the resource available.
     * @return An entity responsible for making the resource available.
     */
    @XmlElement(name = "publisher", namespace = Namespaces.DC)
    public String getPublisher() {
        return publisher;
    }

    /**
     * Set An entity responsible for making the resource available.
     * @param publisher
     */
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    /**
     * Return An entity responsible for making contributions to the content of the resource.
     * @return An entity responsible for making contributions to the content of the resource.
     */
    @XmlElement(name = "contributor", namespace = Namespaces.DC)
    public String getContributor() {
        return contributor;
    }

    /**
     * Set An entity responsible for making contributions to the content of the resource.
     * @param contributor
     */
    public void setContributor(String contributor) {
        this.contributor = contributor;
    }

    /**
     * Return A date of an event in the lifecycle of the resource. 
     * @return A date of an event in the lifecycle of the resource. 
     */
    @XmlElement(name = "modified", namespace = Namespaces.DCT)
    public Date getDate() {
        return date;
    }

    /**
     * Set A date of an event in the lifecycle of the resource. 
     * @param date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Return The nature or genre of the content of the resource.
     * @return The nature or genre of the content of the resource.
     */
    @XmlElement(name = "type", namespace = Namespaces.DC)
    public String getType() {
        return type;
    }

    /**
     * Set The nature or genre of the content of the resource.
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Return The physical or digital manifestation of the resource.
     * @return The physical or digital manifestation of the resource.
     */
    @XmlElement(name = "format", namespace = Namespaces.DC)
    public String getFormat() {
        return format;
    }

    /**
     * Set The physical or digital manifestation of the resource.
     * @param format
     */
    public void setFormat(String format) {
        this.format = format;
    }

    /**
     * Return An unambiguous reference to the resource within a given context.
     * @return An unambiguous reference to the resource within a given context.
     */
    @XmlElement(name = "identifier", namespace = Namespaces.DC)
    public String getIdentifier() {
        return identifier;
    }

    /**
     * Set An unambiguous reference to the resource within a given context.
     * @param identifier
     */
    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    /**
     * Return A Reference to a resource from which the present resource is derived.
     * @return A Reference to a resource from which the present resource is derived.
     */
    @XmlElement(name = "source", namespace = Namespaces.DC)
    public String getSource() {
        return source;
    }

    /**
     * Set A Reference to a resource from which the present resource is derived.
     * @param source
     */
    public void setSource(String source) {
        this.source = source;
    }

    /**
     * Return A language of the intellectual content of the resource.
     * @return A language of the intellectual content of the resource.
     */
    @XmlElement(name = "language", namespace = Namespaces.DC)
    public String getLanguage() {
        return language;
    }

    /**
     * Set A language of the intellectual content of the resource.
     * @param language
     */
    public void setLanguage(String language) {
        this.language = language;
    }

    /**
     * Return A reference to a related resource.
     * @return A reference to a related resource.
     */
    @XmlElement(name = "relation", namespace = Namespaces.DC)
    public String getRelation() {
        return relation;
    }

    /**
     * Set A reference to a related resource.
     * @param relation
     */
    public void setRelation(String relation) {
        this.relation = relation;
    }

    /**
     * Return The extent or scope of the content of the resource.
     * @return The extent or scope of the content of the resource.
     */
    @XmlElement(name = "BoundingBox", namespace = Namespaces.OWS)
    public BoundingBox getCoverage() {
        return coverage;
    }

    /**
     * Set The extent or scope of the content of the resource.
     * @param coverage
     */
    public void setCoverage(BoundingBox coverage) {
        this.coverage = coverage;
    }

    /**
     * Return Information about rights held in and over the resource.
     * @return Information about rights held in and over the resource.
     */
    @XmlElement(name = "rights", namespace = Namespaces.DC)
    public String getRights() {
        return rights;
    }

    /**
     * Set Information about rights held in and over the resource.
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

    /**
     *
     */
    public static Comparator<Record> dateComparatorA = new Comparator<Record>() {

        @Override
        public int compare(Record o1, Record o2) {
           Date date1 = o1.getDate();
           Date date2 = o2.getDate();
           //ascending order
           if (date1 == null) {
                return (date2 == null) ? 0 : -1;
            }
            if (date2 == null) {
                return 1;
           }
           return date1.compareTo(date2);
        }
    };

    /**
     *
     */
    public static Comparator<Record> dateComparatorD = new Comparator<Record>() {

        @Override
        public int compare(Record o1, Record o2) {
           Date date1 = o1.getDate();
           Date date2 = o2.getDate();
           //ascending order
           if (date1 == null) {
                return (date2 == null) ? 0 : 1;
            }
            if (date2 == null) {
                return -1;
           }
           return date2.compareTo(date1);
        }
    };
}
