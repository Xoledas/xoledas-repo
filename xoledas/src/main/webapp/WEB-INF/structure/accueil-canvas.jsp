<c:out value="${name}" />

<canvas id="myChart" height="300" width="1000px"></canvas>

<script>
	var ctx = document.getElementById('myChart');
			
	var options = {
		responsive: false,
		maintainAspectRatio: false
	};
			
	var myChart = new Chart(ctx, {
		type: 'line',
		data: {
			labels: ${liste1},
			datasets: [{
				label: 'Download',
				data: ${liste2},
				backgroundColor: "rgba(153,255,51,0.4)"
				}, {
				label: 'Upload',
				data: [100, 129, 115, 155, 40],
				backgroundColor: "rgba(255,153,0,0.4)"
				}]
		},
		options: options
	});
	
</script>