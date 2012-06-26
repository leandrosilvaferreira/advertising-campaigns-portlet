/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package org.lsp.liferay.portlet.advertising.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import org.lsp.liferay.portlet.advertising.model.Campaign;
import org.lsp.liferay.portlet.advertising.model.CampaignModel;
import org.lsp.liferay.portlet.advertising.model.CampaignSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the Campaign service. Represents a row in the &quot;LSPAC_Campaign&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link org.lsp.liferay.portlet.advertising.model.CampaignModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CampaignImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CampaignImpl
 * @see org.lsp.liferay.portlet.advertising.model.Campaign
 * @see org.lsp.liferay.portlet.advertising.model.CampaignModel
 * @generated
 */
@JSON(strict = true)
public class CampaignModelImpl extends BaseModelImpl<Campaign>
	implements CampaignModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a campaign model instance should use the {@link org.lsp.liferay.portlet.advertising.model.Campaign} interface instead.
	 */
	public static final String TABLE_NAME = "LSPAC_Campaign";
	public static final Object[][] TABLE_COLUMNS = {
			{ "companyId", Types.BIGINT },
			{ "campaignId", Types.BIGINT },
			{ "journalArticlePrimaryKey", Types.BIGINT },
			{ "beginDate", Types.TIMESTAMP },
			{ "endDate", Types.TIMESTAMP },
			{ "campaignStatus", Types.INTEGER }
		};
	public static final String TABLE_SQL_CREATE = "create table LSPAC_Campaign (companyId LONG,campaignId LONG not null primary key,journalArticlePrimaryKey LONG,beginDate DATE null,endDate DATE null,campaignStatus INTEGER)";
	public static final String TABLE_SQL_DROP = "drop table LSPAC_Campaign";
	public static final String ORDER_BY_JPQL = " ORDER BY campaign.campaignId DESC";
	public static final String ORDER_BY_SQL = " ORDER BY LSPAC_Campaign.campaignId DESC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.org.lsp.liferay.portlet.advertising.model.Campaign"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.org.lsp.liferay.portlet.advertising.model.Campaign"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.org.lsp.liferay.portlet.advertising.model.Campaign"),
			true);
	public static long BEGINDATE_COLUMN_BITMASK = 1L;
	public static long CAMPAIGNID_COLUMN_BITMASK = 2L;
	public static long CAMPAIGNSTATUS_COLUMN_BITMASK = 4L;
	public static long COMPANYID_COLUMN_BITMASK = 8L;
	public static long ENDDATE_COLUMN_BITMASK = 16L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static Campaign toModel(CampaignSoap soapModel) {
		Campaign model = new CampaignImpl();

		model.setCompanyId(soapModel.getCompanyId());
		model.setCampaignId(soapModel.getCampaignId());
		model.setJournalArticlePrimaryKey(soapModel.getJournalArticlePrimaryKey());
		model.setBeginDate(soapModel.getBeginDate());
		model.setEndDate(soapModel.getEndDate());
		model.setCampaignStatus(soapModel.getCampaignStatus());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<Campaign> toModels(CampaignSoap[] soapModels) {
		List<Campaign> models = new ArrayList<Campaign>(soapModels.length);

		for (CampaignSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.org.lsp.liferay.portlet.advertising.model.Campaign"));

	public CampaignModelImpl() {
	}

	public long getPrimaryKey() {
		return _campaignId;
	}

	public void setPrimaryKey(long primaryKey) {
		setCampaignId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_campaignId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public Class<?> getModelClass() {
		return Campaign.class;
	}

	public String getModelClassName() {
		return Campaign.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("companyId", getCompanyId());
		attributes.put("campaignId", getCampaignId());
		attributes.put("journalArticlePrimaryKey", getJournalArticlePrimaryKey());
		attributes.put("beginDate", getBeginDate());
		attributes.put("endDate", getEndDate());
		attributes.put("campaignStatus", getCampaignStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long campaignId = (Long)attributes.get("campaignId");

		if (campaignId != null) {
			setCampaignId(campaignId);
		}

		Long journalArticlePrimaryKey = (Long)attributes.get(
				"journalArticlePrimaryKey");

		if (journalArticlePrimaryKey != null) {
			setJournalArticlePrimaryKey(journalArticlePrimaryKey);
		}

		Date beginDate = (Date)attributes.get("beginDate");

		if (beginDate != null) {
			setBeginDate(beginDate);
		}

		Date endDate = (Date)attributes.get("endDate");

		if (endDate != null) {
			setEndDate(endDate);
		}

		Integer campaignStatus = (Integer)attributes.get("campaignStatus");

		if (campaignStatus != null) {
			setCampaignStatus(campaignStatus);
		}
	}

	@JSON
	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_columnBitmask |= COMPANYID_COLUMN_BITMASK;

		if (!_setOriginalCompanyId) {
			_setOriginalCompanyId = true;

			_originalCompanyId = _companyId;
		}

		_companyId = companyId;
	}

	public long getOriginalCompanyId() {
		return _originalCompanyId;
	}

	@JSON
	public long getCampaignId() {
		return _campaignId;
	}

	public void setCampaignId(long campaignId) {
		_columnBitmask = -1L;

		if (!_setOriginalCampaignId) {
			_setOriginalCampaignId = true;

			_originalCampaignId = _campaignId;
		}

		_campaignId = campaignId;
	}

	public long getOriginalCampaignId() {
		return _originalCampaignId;
	}

	@JSON
	public long getJournalArticlePrimaryKey() {
		return _journalArticlePrimaryKey;
	}

	public void setJournalArticlePrimaryKey(long journalArticlePrimaryKey) {
		_journalArticlePrimaryKey = journalArticlePrimaryKey;
	}

	@JSON
	public Date getBeginDate() {
		return _beginDate;
	}

	public void setBeginDate(Date beginDate) {
		_columnBitmask |= BEGINDATE_COLUMN_BITMASK;

		if (_originalBeginDate == null) {
			_originalBeginDate = _beginDate;
		}

		_beginDate = beginDate;
	}

	public Date getOriginalBeginDate() {
		return _originalBeginDate;
	}

	@JSON
	public Date getEndDate() {
		return _endDate;
	}

	public void setEndDate(Date endDate) {
		_columnBitmask |= ENDDATE_COLUMN_BITMASK;

		if (_originalEndDate == null) {
			_originalEndDate = _endDate;
		}

		_endDate = endDate;
	}

	public Date getOriginalEndDate() {
		return _originalEndDate;
	}

	@JSON
	public int getCampaignStatus() {
		return _campaignStatus;
	}

	public void setCampaignStatus(int campaignStatus) {
		_columnBitmask |= CAMPAIGNSTATUS_COLUMN_BITMASK;

		if (!_setOriginalCampaignStatus) {
			_setOriginalCampaignStatus = true;

			_originalCampaignStatus = _campaignStatus;
		}

		_campaignStatus = campaignStatus;
	}

	public int getOriginalCampaignStatus() {
		return _originalCampaignStatus;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public Campaign toEscapedModel() {
		if (_escapedModelProxy == null) {
			_escapedModelProxy = (Campaign)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelProxyInterfaces,
					new AutoEscapeBeanHandler(this));
		}

		return _escapedModelProxy;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			Campaign.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Object clone() {
		CampaignImpl campaignImpl = new CampaignImpl();

		campaignImpl.setCompanyId(getCompanyId());
		campaignImpl.setCampaignId(getCampaignId());
		campaignImpl.setJournalArticlePrimaryKey(getJournalArticlePrimaryKey());
		campaignImpl.setBeginDate(getBeginDate());
		campaignImpl.setEndDate(getEndDate());
		campaignImpl.setCampaignStatus(getCampaignStatus());

		campaignImpl.resetOriginalValues();

		return campaignImpl;
	}

	public int compareTo(Campaign campaign) {
		int value = 0;

		if (getCampaignId() < campaign.getCampaignId()) {
			value = -1;
		}
		else if (getCampaignId() > campaign.getCampaignId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		value = value * -1;

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		Campaign campaign = null;

		try {
			campaign = (Campaign)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = campaign.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public void resetOriginalValues() {
		CampaignModelImpl campaignModelImpl = this;

		campaignModelImpl._originalCompanyId = campaignModelImpl._companyId;

		campaignModelImpl._setOriginalCompanyId = false;

		campaignModelImpl._originalCampaignId = campaignModelImpl._campaignId;

		campaignModelImpl._setOriginalCampaignId = false;

		campaignModelImpl._originalBeginDate = campaignModelImpl._beginDate;

		campaignModelImpl._originalEndDate = campaignModelImpl._endDate;

		campaignModelImpl._originalCampaignStatus = campaignModelImpl._campaignStatus;

		campaignModelImpl._setOriginalCampaignStatus = false;

		campaignModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Campaign> toCacheModel() {
		CampaignCacheModel campaignCacheModel = new CampaignCacheModel();

		campaignCacheModel.companyId = getCompanyId();

		campaignCacheModel.campaignId = getCampaignId();

		campaignCacheModel.journalArticlePrimaryKey = getJournalArticlePrimaryKey();

		Date beginDate = getBeginDate();

		if (beginDate != null) {
			campaignCacheModel.beginDate = beginDate.getTime();
		}
		else {
			campaignCacheModel.beginDate = Long.MIN_VALUE;
		}

		Date endDate = getEndDate();

		if (endDate != null) {
			campaignCacheModel.endDate = endDate.getTime();
		}
		else {
			campaignCacheModel.endDate = Long.MIN_VALUE;
		}

		campaignCacheModel.campaignStatus = getCampaignStatus();

		return campaignCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{companyId=");
		sb.append(getCompanyId());
		sb.append(", campaignId=");
		sb.append(getCampaignId());
		sb.append(", journalArticlePrimaryKey=");
		sb.append(getJournalArticlePrimaryKey());
		sb.append(", beginDate=");
		sb.append(getBeginDate());
		sb.append(", endDate=");
		sb.append(getEndDate());
		sb.append(", campaignStatus=");
		sb.append(getCampaignStatus());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(22);

		sb.append("<model><model-name>");
		sb.append("org.lsp.liferay.portlet.advertising.model.Campaign");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>campaignId</column-name><column-value><![CDATA[");
		sb.append(getCampaignId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>journalArticlePrimaryKey</column-name><column-value><![CDATA[");
		sb.append(getJournalArticlePrimaryKey());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>beginDate</column-name><column-value><![CDATA[");
		sb.append(getBeginDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>endDate</column-name><column-value><![CDATA[");
		sb.append(getEndDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>campaignStatus</column-name><column-value><![CDATA[");
		sb.append(getCampaignStatus());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = Campaign.class.getClassLoader();
	private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
			Campaign.class
		};
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _campaignId;
	private long _originalCampaignId;
	private boolean _setOriginalCampaignId;
	private long _journalArticlePrimaryKey;
	private Date _beginDate;
	private Date _originalBeginDate;
	private Date _endDate;
	private Date _originalEndDate;
	private int _campaignStatus;
	private int _originalCampaignStatus;
	private boolean _setOriginalCampaignStatus;
	private long _columnBitmask;
	private Campaign _escapedModelProxy;
}