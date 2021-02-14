create table RECOG_FriendshipRecognition (
	mvccVersion LONG default 0 not null,
	uuid_ VARCHAR(75) null,
	recognitionId LONG not null primary key,
	detailA VARCHAR(75) null,
	detailB VARCHAR(75) null,
	detailC VARCHAR(75) null
);

create table RECOG_PerformanceRecognition (
	mvccVersion LONG default 0 not null,
	uuid_ VARCHAR(75) null,
	recognitionId LONG not null primary key,
	detail1 VARCHAR(75) null,
	detail2 VARCHAR(75) null
);

create table RECOG_Recognition (
	mvccVersion LONG default 0 not null,
	uuid_ VARCHAR(75) null,
	recognitionId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	toUserId LONG,
	toUserName VARCHAR(75) null,
	value VARCHAR(75) null,
	subject VARCHAR(75) null
);