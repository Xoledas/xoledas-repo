<c:out value="${name}" />

<p class="title-chart">Débit Download</p>
<canvas id="downChart" height="300" width="1000px"></canvas>
<p class="title-chart">Débit Upload</p>
<canvas id="upChart" height="300" width="1000px"></canvas>
<p class="title-chart">Ping</p>
<canvas id="pingChart" height="300" width="1000px"></canvas>

<script>
	var ctx_d = document.getElementById('downChart');
	var ctx_u = document.getElementById('upChart');
	var ctx_p = document.getElementById('pingChart');
			
	var options = {
		responsive: false,
		maintainAspectRatio: false
	};
			
	var myChart_d = new Chart(ctx_d, {
		type: 'line',
		data: {
			labels: ${formattedMap.get("ldate")},
			datasets: [{
				label: 'Download',
				data: ${formattedMap.get("ldownload")},
				backgroundColor: "rgba(161,19,19,0.5)"
				}]
		},
		options: options
	});
	
	var myChart_u = new Chart(ctx_u, {
		type: 'line',
		data: {
			labels: ${formattedMap.get("ldate")},
			datasets: [{
				label: 'Upload',
				data: ${formattedMap.get("lupload")},
				backgroundColor: "rgba(161,19,19,0.5)"
				}]
		},
		options: options
	});
	
	var myChart_p = new Chart(ctx_p, {
		type: 'line',
		data: {
			labels: ${formattedMap.get("ldate")},
			datasets: [{
				label: 'Ping',
				data: ${formattedMap.get("lping")},
				backgroundColor: "rgba(161,19,19,0.5)"
				}]
		},
		options: options
	});
	
</script>