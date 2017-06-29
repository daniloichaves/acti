function setMask(uuid, mask) {
	// alert('teste');
	var selector = "#" + uuid;
	jQuery(selector).setMask(mask);
}

function unsetMask(uuid) {
	jq('#' + uuid).unsetMask().val('');
}

function applyZipCodeMask(compId) {
	applyMask(compId, "99.999-999");
}

function applyPhoneMask(compId) {
	applyMask(compId, "(99) 9999-9999");
}

function applyPlacaMask(compId) {
	applyMask(compId, "(99) 9999-9999");
}

function applyMask(compId, mask) {
	compId = '#' + compId;
	jQuery(compId).mask(mask);
}